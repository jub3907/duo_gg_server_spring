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
    public int maxNewPlayerLevel;

    public List<Integer> freeChampionIdsForNewPlayers;

    public List<Integer> freeChampionIds;
}
