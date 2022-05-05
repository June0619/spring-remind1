package jwjung.spring.remind.controller;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.dto.MemberDTO;
import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> list() {
        return ResponseEntity.ok(memberRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> join(@RequestBody MemberDTO memberDTO) {

        System.out.println("memberDTO = " + memberDTO.toString());

        Member member = Member.builder()
                .name(memberDTO.getName())
                .grade(memberDTO.getMemberGrade())
                .build();

        Long resource = memberService.join(member);

        return ResponseEntity.created(URI.create(resource.toString())).build();
    }

}
