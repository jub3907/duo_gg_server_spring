package duo.gg.server.mastery;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@AllArgsConstructor
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
}
