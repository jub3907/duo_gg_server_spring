package duo.gg.server.api.dto.league;

import duo.gg.server.api.dto.league.MiniSeriesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueEntryDto {

    private String leagueId;

    // Player's summonerId (Encrypted)
    private String summonerId;

    private String summonerName;

    private String queueType;

    private String tier;

    private String rank;

    private int leaguePoints;

    // Winning team on Summoners Rift. First placement in Teamfight Tactics.
    private int wins;

    // Losing team on Summoners Rift. Second through eighth placement in Teamfight Tactics.
    private int losses;

    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;

    private MiniSeriesDto miniSeries;

}
