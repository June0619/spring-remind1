package jwjung.spring.remind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member createdBy;
    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member modifiedBy;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
