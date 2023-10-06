package com.monpro.ticket.member.controller;


import com.monpro.ticket.common.resp.ApiResponse;
import com.monpro.ticket.member.req.MemberLoginCodeRequest;
import com.monpro.ticket.member.req.MemberRegisterRequest;
import com.monpro.ticket.member.service.MemberService;
import jakarta.validation.Valid;
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
    public ApiResponse<Integer> count() {
        return new ApiResponse<>(memberService.count());
    }

    @PostMapping("/register")
    public ApiResponse<Long> register(@Valid MemberRegisterRequest memberRegisterRequest) {
        final long register = memberService.register(memberRegisterRequest);

        return new ApiResponse<>(register);
    }
    @PostMapping("/loginCode")
    public ApiResponse<String> loginCode(@Valid MemberLoginCodeRequest memberLoginCodeRequest) {
        final String loginCode = memberService.loginCode(memberLoginCodeRequest);
        return new ApiResponse<>(loginCode);
    }

}
