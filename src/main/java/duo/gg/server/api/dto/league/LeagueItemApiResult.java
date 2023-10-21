package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// LEAGUE-V4, /lol/league/v4/challengerleagues/by-queue/{queue}
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueItemApiResult {

    private Boolean freshBlood;

    // winning team on Summoners Rift
    private Integer wins;

    private String summonerName;

    private MiniSeriesApiResult miniSeries;

    private Boolean inactive;

    private Boolean veteran;

    private Boolean hotStreak;

    private String rank;

    private Integer leaguePoints;

    private Integer losses;

    private String summonerId;

}
