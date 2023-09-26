package com.monpro.ticket.member.service;

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
            throw new RuntimeException("Mobile has been registered");
        } else {
            Member member = new Member();
            //TODO: use uuid in production
            member.setId(System.currentTimeMillis());
            member.setMobile(mobile);
            memberMapper.insert(member);
            return member.getId();
        }
    }
}
