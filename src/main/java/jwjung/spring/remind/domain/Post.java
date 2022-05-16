package jwjung.spring.remind.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member")
    private Member author;
    private String text;

    @Builder
    public Post(Member author, String text) {
        this.author = author;
        this.text = text;
    }

}
