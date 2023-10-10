package duo.gg.server.api.dto.champion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionInfoDto {
    private int maxNewPlayerLevel;

    private List<Integer> freeChampionIdsForNewPlayers;

    private List<Integer> freeChampionIds;
}
