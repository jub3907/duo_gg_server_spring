package duo.gg.server.summoner.dto;

import duo.gg.server.summoner.entity.Summoner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SummonerDto {
    private Long revisionDate;
    private Integer profileIconId;
    private String name;
    private String puuid;
    private String summonerId;
    private Long summonerLevel;

    public SummonerDto(Summoner summoner) {
        revisionDate = summoner.getRevisionDate();
        profileIconId = summoner.getProfileIconId();
        name = summoner.getName();
        puuid = summoner.getPuuid();
        summonerId = summoner.getId();
        summonerLevel = summoner.getSummonerLevel();
    }
}
