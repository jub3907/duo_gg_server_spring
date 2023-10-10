package duo.gg.server.summoner.entity;

import duo.gg.server.api.dto.summoner.SummonerApiResult;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@Getter
@NoArgsConstructor
@ToString(of = {"id", "name", "puuid", "accountId"})
public class Summoner {

    @Id
    @Column(name = "summoner_id")
    private String id;

    private String accountId;

    private int profileIconId;

    private Long revisionDate;

    private String name;

    private String puuid;

    private Long summonerLevel;

    //TODO: Comment 추가
    //TODO: mastery list 추가?

    public Summoner(SummonerApiResult dto) {
        this.id = dto.getId();
        this.accountId = dto.getAccountId();
        this.profileIconId = dto.getProfileIconId();
        this.revisionDate = dto.getRevisionDate();
        this.name = dto.getName();
        this.puuid = dto.getPuuid();
        this.summonerLevel = dto.getSummonerLevel();
    }

    public void updateByApiResult(SummonerApiResult dto) {
        this.accountId = dto.getAccountId();
        this.profileIconId = dto.getProfileIconId();
        this.revisionDate = dto.getRevisionDate();
        this.name = dto.getName();
        this.puuid = dto.getPuuid();
        this.summonerLevel = dto.getSummonerLevel();
    }

}
