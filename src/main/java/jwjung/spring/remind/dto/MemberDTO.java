package jwjung.spring.remind.dto;

import jwjung.spring.remind.domain.MemberGrade;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {

    private String name;
    private MemberGrade memberGrade;

}
