package jwjung.spring.remind.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @Column(name = "POST_ID")
    private Long id;

}
