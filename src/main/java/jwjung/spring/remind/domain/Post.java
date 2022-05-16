package jwjung.spring.remind.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @Column(name = "POST_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member")
    private Member author;
    private String text;

    @Builder
    public Post(Member member, String text) {
        this.author = member;
        this.text = text;
    }

}
