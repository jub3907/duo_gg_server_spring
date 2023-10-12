package duo.gg.server.mastery;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class MasteryId {
    @Column(name = "mastery_puuid")
    private String puuid;

    @Column(name = "mastery_champion_id")
    private Long championId;
}
