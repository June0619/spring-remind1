package jwjung.spring.remind.controller;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.dto.MemberDTO;
import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping
    public String list() {
        return memberRepository.findAll().toString();
    }

    @PostMapping
    public String join(@RequestBody MemberDTO memberDTO) {

        System.out.println("memberDTO = " + memberDTO.toString());

        Member member = Member.builder()
                .name(memberDTO.getName())
                .grade(memberDTO.getMemberGrade())
                .build();

        memberService.join(member);

//        return memberService.join()
        return String.valueOf(member.getId());
    }

}
