package duo.gg.server.api.dto.champion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionInfoApiResult {
    private Integer maxNewPlayerLevel;

    private List<Integer> freeChampionIdsForNewPlayers;

    private List<Integer> freeChampionIds;
}
