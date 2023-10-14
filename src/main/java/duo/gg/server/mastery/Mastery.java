package duo.gg.server.mastery;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Mastery {

    @EmbeddedId
    private MasteryId id;

    private Long championPointsUntilNextLevel;
    private boolean chestGranted;
    private Long lastPlayTime;
    private int championLevel;
    private String summonerId;
    private int championPoints;
    private Long championPointsSinceLastLevel;
    private int tokenEarned;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
