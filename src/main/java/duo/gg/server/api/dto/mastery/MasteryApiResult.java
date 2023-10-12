package duo.gg.server.api.dto.mastery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasteryApiResult {
    // Player Universal Unique Identifier. Exact length of 78 characters. (Encrypted)
    // 플레이어의 고유 ID값. 78글자로 이루어짐
    private String puuid;

    // Champion ID for this entry.
    private Long championId;

    // Number of points needed to achieve next level. Zero if player reached maximum champion level for this champion.
    // 다음 레벨을 달성하기 위한 포인트 값. 해당 챔피언 레벨이 최대일 때, 0.
    private Long championPointsUntilNextLevel;

    // Is chest granted for this champion or not in current season.
    // 이번 시즌에, 해당 챔피언에 대한 상자를 얻었는지 여부
    private boolean chestGranted;

    // Last time this champion was played by this player - in Unix milliseconds time format.
    private Long lastPlayTime;

    // Champion level for specified player and champion combination.
    private int championLevel;

    // Summoner ID for this entry. (Encrypted)
    private String summonerId;

    // Total number of champion points for this player and champion combination
    // they are used to determine championLevel.
    private int championPoints;

    // Number of points earned since current level has been achieved.
    private Long championPointsSinceLastLevel;

    // The token earned for this champion at the current championLevel.
    // When the championLevel is advanced the tokensEarned resets to 0.
    private int tokensEarned;


}
