package jwjung.spring.remind.domain;

import lombok.*;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue @Setter
    @Column(name = "MEMBER_ID")
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
