package duo.gg.server.league.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueDto {
    private String profileIconId;
    private String summonerName;
    private String tier;
    private String leaguePoints;
    private String summonerLevel;
    private Integer wins;
    private Integer losses;
}
