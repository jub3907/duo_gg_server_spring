package duo.gg.server.league.dto;

import duo.gg.server.constant.QueueEnum;
import duo.gg.server.constant.TierEnum;
import duo.gg.server.league.entry.League;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueDto {

    private QueueEnum queueType;
    private TierEnum tier;
    private String rank;

    private Boolean freshBlood;
    private Boolean inactive;
    private Boolean veteran;
    private Boolean hotStreak;

    private Integer wins;
    private Integer leaguePoints;
    private Integer losses;

    public LeagueDto(League league) {
        queueType = league.getQueueType();
        tier = league.getTier();
        rank = league.getRank();
        freshBlood = league.getFreshBlood();
        inactive = league.getInactive();
        veteran = league.getVeteran();
        hotStreak = league.getHotStreak();
        wins = league.getWins();
        leaguePoints = league.getLeaguePoints();
        losses = league.getLosses();
    }
}
