package duo.gg.server.mastery.dto;

import duo.gg.server.mastery.Mastery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MasteryDto {
    private Long championId;
    private Integer championLevel;
    private Integer championPoints;
    private Long lastPlayTime;

    public MasteryDto(Mastery mastery) {
        championId = mastery.getId().getChampionId();
        championLevel = mastery.getChampionLevel();
        championPoints = mastery.getChampionPoints();
        lastPlayTime = mastery.getLastPlayTime();
    }

    public List<MasteryDto> masteryMapper(List<Mastery> masteries) {
        return masteries.stream()
                .map(MasteryDto::new)
                .collect(Collectors.toList());
    }
}
