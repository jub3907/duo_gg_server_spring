package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;

// LEAGUE-V4, /lol/league/v4/challengerleagues/by-queue/{queue}
@Getter
@AllArgsConstructor
public class LeagueItemDto {

    public boolean freshBlood;

    // winning team on Summoners Rift
    public int wins;

    public String summonerName;

    public MiniSeriesDto miniSeries;

    public boolean inactive;

    public boolean veteran;

    public boolean hotStreak;

    public String rank;

    public int leaguePoints;

    public int losses;

    public String summonerId;

}
