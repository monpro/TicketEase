package com.monpro.ticket.member.controller;


import com.monpro.ticket.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/count")
    public int count() {
        return memberService.count();
    }

    @PostMapping("/register")
    public long register(String mobile) {
        System.out.println("modile is" + mobile);
        return memberService.register(mobile);
    }
}
