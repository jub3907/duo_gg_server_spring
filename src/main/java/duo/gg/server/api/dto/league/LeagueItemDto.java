package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// LEAGUE-V4, /lol/league/v4/challengerleagues/by-queue/{queue}
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueItemDto {

    private boolean freshBlood;

    // winning team on Summoners Rift
    private int wins;

    private String summonerName;

    private MiniSeriesDto miniSeries;

    private boolean inactive;

    private boolean veteran;

    private boolean hotStreak;

    private String rank;

    private int leaguePoints;

    private int losses;

    private String summonerId;

}
