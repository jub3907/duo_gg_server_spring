package duo.gg.server.league.entry;

import duo.gg.server.api.dto.league.LeagueEntryApiResult;
import duo.gg.server.api.dto.league.LeagueItemApiResult;
import duo.gg.server.constant.QueueEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class League {

    @Id @GeneratedValue
    @Column(name = "league_generated_id")
    private Long id;

    private String leagueId;

    private String tier;

    @Enumerated(EnumType.STRING)
    private QueueEnum queueType;

    private Boolean freshBlood;
    private Boolean inactive;
    private Boolean veteran;
    private Boolean hotStreak;

    private Integer wins;
    private Integer leaguePoints;
    private Integer losses;

    private String summonerId;
    private String summonerName;
    private String rank;

    public League(LeagueItemApiResult entry,
                  String leagueId, String tier, String queueType) {
        this.leagueId = leagueId;
        this.tier = tier;
        this.queueType = QueueEnum.valueOf(queueType);

        this.freshBlood = entry.getFreshBlood();
        this.inactive = entry.getInactive();
        this.veteran = entry.getVeteran();
        this.hotStreak = entry.getHotStreak();

        this.wins = entry.getWins();
        this.leaguePoints = entry.getLeaguePoints();
        this.losses = entry.getLosses();
        this.summonerId = entry.getSummonerId();
        this.summonerName = entry.getSummonerName();
        this.rank = entry.getRank();
    }

    public League(LeagueEntryApiResult result) {
        leagueId = result.getLeagueId();
        tier = result.getTier();
        queueType = QueueEnum.valueOf(result.getQueueType());

        freshBlood = result.getFreshBlood();
        inactive = result.getInactive();
        veteran = result.getVeteran();
        hotStreak = result.getHotStreak();

        wins = result.getWins();
        leaguePoints = result.getLeaguePoints();
        losses = result.getLosses();

        summonerId = result.getSummonerId();
        summonerName = result.getSummonerName();
        rank = result.getRank();
    }

    public void updateByItem(LeagueItemApiResult result) {

        this.freshBlood = result.getFreshBlood();
        this.inactive = result.getInactive();
        this.veteran = result.getVeteran();
        this.hotStreak = result.getHotStreak();

        this.wins = result.getWins();
        this.leaguePoints = result.getLeaguePoints();
        this.losses = result.getLosses();

        this.summonerName = result.getSummonerName();
        this.rank = result.getRank();
    }

    public void updateByEntry(LeagueEntryApiResult result) {

        leagueId = result.getLeagueId();
        tier = result.getTier();
        this.freshBlood = result.getFreshBlood();
        this.inactive = result.getInactive();
        this.veteran = result.getVeteran();
        this.hotStreak = result.getHotStreak();
        wins = result.getWins();
        leaguePoints = result.getLeaguePoints();
        losses = result.getLosses();
        summonerName = result.getSummonerName();
        rank = result.getRank();
    }
}
