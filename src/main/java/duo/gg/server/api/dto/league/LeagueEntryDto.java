package duo.gg.server.api.dto.league;

import duo.gg.server.api.dto.league.MiniSeriesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LeagueEntryDto {

    public String leagueId;

    // Player's summonerId (Encrypted)
    public String summonerId;

    public String summonerName;

    public String queueType;

    public String tier;

    public String rank;

    public int leaguePoints;

    // Winning team on Summoners Rift. First placement in Teamfight Tactics.
    public int wins;

    // Losing team on Summoners Rift. Second through eighth placement in Teamfight Tactics.
    public int losses;

    public boolean hotStreak;
    public boolean veteran;
    public boolean freshBlood;
    public boolean inactive;

    public MiniSeriesDto miniSeries;

}
