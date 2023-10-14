package com.monpro.ticket.member.controller;


import com.monpro.ticket.common.resp.ApiResponse;
import com.monpro.ticket.member.req.MemberLoginCodeRequest;
import com.monpro.ticket.member.req.MemberLoginRequest;
import com.monpro.ticket.member.req.MemberRegisterRequest;
import com.monpro.ticket.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse<String> loginCode(@Valid @RequestBody MemberLoginCodeRequest memberLoginCodeRequest) {
        final String loginCode = memberService.loginCode(memberLoginCodeRequest);
        return new ApiResponse<>(loginCode);
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@Valid @RequestBody MemberLoginRequest memberLoginRequest) {
        memberService.login(memberLoginRequest);
        return new ApiResponse<>("login successfully");
    }
}
