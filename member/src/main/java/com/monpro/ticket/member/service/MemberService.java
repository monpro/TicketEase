package com.monpro.ticket.member.service;

import cn.hutool.core.util.RandomUtil;
import com.monpro.ticket.common.exception.BusinessException;
import com.monpro.ticket.common.exception.BusinessExceptionEnum;
import com.monpro.ticket.common.util.SnowFlakeUtil;
import com.monpro.ticket.member.domain.Member;
import com.monpro.ticket.member.domain.MemberExample;
import com.monpro.ticket.member.domain.MemberLogin;
import com.monpro.ticket.member.domain.MemberLoginExample;
import com.monpro.ticket.member.mapper.MemberLoginMapper;
import com.monpro.ticket.member.mapper.MemberMapper;
import com.monpro.ticket.member.req.MemberLoginCodeRequest;
import com.monpro.ticket.member.req.MemberLoginRequest;
import com.monpro.ticket.member.req.MemberRegisterRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    private final MemberLoginMapper memberLoginMapper;
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    public MemberService(MemberMapper mapper, MemberLoginMapper memberLoginMapper) {
        this.memberMapper = mapper;
        this.memberLoginMapper = memberLoginMapper;
    }

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterRequest request) {
        String mobile = request.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (!members.isEmpty()) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        } else {
            Member member = new Member();
            member.setId(SnowFlakeUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
            return member.getId();
        }
    }


    public String loginCode(MemberLoginCodeRequest request) {
        String mobile = request.getMobile();
        MemberLoginExample memberLoginExample = new MemberLoginExample();
        memberLoginExample.createCriteria().andMobileEqualTo(mobile);
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        MemberLogin memberLogin = memberLoginMapper.selectByPrimaryKey(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (members.isEmpty()) {
            log.info("user is not registered");
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        } else {
            log.info("user is registered");
            if (memberLogin == null) {
                return generateLoginCode(mobile);
            } else {
                Date codeGenerateTimestamp = memberLogin.getCodeGenerateTimestamp();
                if (System.currentTimeMillis() - codeGenerateTimestamp.getTime() < 1000 * 60) {
                    log.info("login code request too often");
                    throw new BusinessException(BusinessExceptionEnum.LOGIN_CODE_REQUEST_TOO_OFTEN);
                } else {
                    return updateLoginCode(mobile);
                }
            }
        }
    }

    public void login(MemberLoginRequest request) {
        String mobile = request.getMobile();
        String code = request.getCode();
        MemberLoginExample memberLoginExample = new MemberLoginExample();
        memberLoginExample.createCriteria().andMobileEqualTo(mobile).andCodeEqualTo(code);
        List<MemberLogin> memberLogins = memberLoginMapper.selectByExample(memberLoginExample);
        if (memberLogins.isEmpty()) {
            log.info("login code is not correct");
            throw new BusinessException(BusinessExceptionEnum.LOGIN_CODE_NOT_CORRECT);
        } else {
            log.info("login code is correct");
        }
    }

    private String generateLoginCode(String mobile) {
        String randomCode = RandomUtil.randomString(6);
        memberLoginMapper.insert(new MemberLogin(mobile, randomCode, new Date()));
        return randomCode;
    }

    private String updateLoginCode(String mobile) {
        String randomCode = RandomUtil.randomString(6);
        memberLoginMapper.updateByPrimaryKey(new MemberLogin(mobile, randomCode, new Date()));
        return randomCode;
    }
}
