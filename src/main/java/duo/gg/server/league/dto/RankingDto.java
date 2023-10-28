package duo.gg.server.league.dto;

import duo.gg.server.league.entry.League;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {
    private String profileIconId;
    private String summonerName;
    private String tier;
    private String leaguePoints;
    private Integer summonerLevel;
    private Integer wins;
    private Integer losses;
}
