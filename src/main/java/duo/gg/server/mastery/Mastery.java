package duo.gg.server.mastery;

import duo.gg.server.api.dto.mastery.MasteryApiResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Mastery {

    @EmbeddedId
    private MasteryId id;

    private Long championPointsUntilNextLevel;
    private Boolean chestGranted;
    private Long lastPlayTime;
    private Integer championLevel;
    private String summonerId;
    private Integer championPoints;
    private Long championPointsSinceLastLevel;
    private Integer tokenEarned;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    Mastery(MasteryApiResult apiResult) {
        id = new MasteryId(apiResult.getPuuid(), apiResult.getChampionId());

        championPointsUntilNextLevel = apiResult.getChampionPointsUntilNextLevel();
        chestGranted = apiResult.getChestGranted();
        lastPlayTime = apiResult.getLastPlayTime();
        championLevel = apiResult.getChampionLevel();
        summonerId = apiResult.getSummonerId();
        championPoints = apiResult.getChampionPoints();
        championPointsSinceLastLevel = apiResult.getChampionPointsSinceLastLevel();
        tokenEarned = apiResult.getTokensEarned();
    }

    public void updateByApiResult(MasteryApiResult apiResult) {

        championPointsUntilNextLevel = apiResult.getChampionPointsUntilNextLevel();
        chestGranted = apiResult.getChestGranted();
        lastPlayTime = apiResult.getLastPlayTime();
        championLevel = apiResult.getChampionLevel();
        summonerId = apiResult.getSummonerId();
        championPoints = apiResult.getChampionPoints();
        championPointsSinceLastLevel = apiResult.getChampionPointsSinceLastLevel();
        tokenEarned = apiResult.getTokensEarned();
    }
}
