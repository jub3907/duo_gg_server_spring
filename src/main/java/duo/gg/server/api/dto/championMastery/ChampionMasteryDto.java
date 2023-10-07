package duo.gg.server.api.dto.championMastery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionMasteryDto {
    // Player Universal Unique Identifier. Exact length of 78 characters. (Encrypted)
    // 플레이어의 고유 ID값. 78글자로 이루어짐
    public String puuid;

    // Number of points needed to achieve next level. Zero if player reached maximum champion level for this champion.
    // 다음 레벨을 달성하기 위한 포인트 값. 해당 챔피언 레벨이 최대일 때, 0.
    public Long championPointsUntilNextLevel;

    // Is chest granted for this champion or not in current season.
    // 이번 시즌에, 해당 챔피언에 대한 상자를 얻었는지 여부
    public boolean chestGranted;

    // Champion ID for this entry.
    public Long championId;

    // Last time this champion was played by this player - in Unix milliseconds time format.
    public Long lastPlayTime;

    // Champion level for specified player and champion combination.
    public int championLevel;

    // Summoner ID for this entry. (Encrypted)
    public String summonerId;

    // Total number of champion points for this player and champion combination
    // they are used to determine championLevel.
    public int championPoints;

    // Number of points earned since current level has been achieved.
    public Long championPointsSinceLastLevel;

    // The token earned for this champion at the current championLevel.
    // When the championLevel is advanced the tokensEarned resets to 0.
    public int tokensEarned;


}
