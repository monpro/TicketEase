package com.monpro.ticket.member.service;

import com.monpro.ticket.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberMapper mapper;

    @Autowired
    public MemberService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    public int count() {
        return Math.toIntExact(mapper.countByExample(null));
    }
}
