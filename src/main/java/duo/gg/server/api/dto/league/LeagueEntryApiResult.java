package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueEntryApiResult {

    private String leagueId;

    // Player's summonerId (Encrypted)
    private String summonerId;

    private String summonerName;

    private String queueType;

    private String tier;

    private String rank;

    private Integer leaguePoints;

    // Winning team on Summoners Rift. First placement in Teamfight Tactics.
    private Integer wins;

    // Losing team on Summoners Rift. Second through eighth placement in Teamfight Tactics.
    private Integer losses;

    private Boolean hotStreak;
    private Boolean veteran;
    private Boolean freshBlood;
    private Boolean inactive;

    private MiniSeriesApiResult miniSeries;

}
