package jwjung.spring.remind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue @Setter
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberGrade Grade;

}
