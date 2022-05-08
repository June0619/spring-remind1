package jwjung.spring.remind.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Post {

    @Id
    @Column(name = "POST_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member")
    private Member author;
    private String text;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
