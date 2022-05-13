package jwjung.spring.remind.domain;

import javax.persistence.Entity;
import java.time.LocalDateTime;

public abstract class BaseEntity {

    private Member createdBy;
    private Member modifiedBy;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
