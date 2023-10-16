package duo.gg.server.match.entity;

import duo.gg.server.api.dto.match.TeamApiResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private Match match;

    private int teamId;
    private boolean win;

    private int baronKills;
    private int championKills;
    private int dragonKills;
    private int inhibitorKills;
    private int riftHeraldKills;
    private int towerKills;

    Team(TeamApiResult result, Match match) {
        this.match = match;

        teamId = result.getTeamId();
        win = result.isWin();
        baronKills = result.getObjectives().getBaron().getKills();
        championKills = result.getObjectives().getChampion().getKills();
        dragonKills = result.getObjectives().getDragon().getKills();
        inhibitorKills = result.getObjectives().getInhibitor().getKills();
        riftHeraldKills = result.getObjectives().getRiftHerald().getKills();
        towerKills = result.getObjectives().getTower().getKills();
    }
}
