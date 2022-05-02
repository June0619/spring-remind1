package jwjung.spring.remind.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @NoArgsConstructor
public class Member {

    @Id @GeneratedValue @Setter
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberGrade grade;

    @Builder
    public Member(String name, MemberGrade grade) {
        this.name = name;
        this.grade = grade;
    }

}
