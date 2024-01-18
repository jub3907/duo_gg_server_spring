package duo.gg.server.league.dto;

import duo.gg.server.league.entry.League;
import duo.gg.server.summoner.entity.Summoner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {
    private Integer profileIconId;
    private String summonerName;
    private String summonerId;

    private String puuid;
    private String tier;
    private Integer leaguePoints;
    private Long summonerLevel;
    private Integer wins;
    private Integer losses;

    public RankingDto(League l, Summoner s) {
        if (s != null) {
            this.profileIconId = s.getProfileIconId();
            this.summonerLevel = s.getSummonerLevel();
            this.puuid = s.getPuuid();
        }
        this.summonerName = l.getSummonerName();
        this.tier = l.getTier().toString();
        this.leaguePoints = l.getLeaguePoints();
        this.wins = l.getWins();
        this.losses = l.getLosses();
        this.summonerId = l.getSummonerId();
    }
}
