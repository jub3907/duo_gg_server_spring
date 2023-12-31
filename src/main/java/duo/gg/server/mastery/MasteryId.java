package duo.gg.server.mastery;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MasteryId {
    private String puuid;

    private Long championId;
}
