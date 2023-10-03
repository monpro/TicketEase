package com.monpro.ticket.member.service;

import com.monpro.ticket.common.exception.BusinessException;
import com.monpro.ticket.common.exception.BusinessExceptionEnum;
import com.monpro.ticket.common.util.SnowFlakeUtil;
import com.monpro.ticket.member.domain.Member;
import com.monpro.ticket.member.domain.MemberExample;
import com.monpro.ticket.member.mapper.MemberMapper;
import com.monpro.ticket.member.req.MemberRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper mapper) {
        this.memberMapper = mapper;
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
}
