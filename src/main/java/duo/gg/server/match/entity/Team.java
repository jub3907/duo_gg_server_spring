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
    @Id @GeneratedValue
    @Column(name = "team_generated_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private MatchInfo matchInfo;

    private Integer teamId;
    private Boolean win;

    private Integer baronKills;
    private Integer championKills;
    private Integer dragonKills;
    private Integer inhibitorKills;
    private Integer riftHeraldKills;
    private Integer towerKills;

    Team(TeamApiResult result, MatchInfo match) {
        this.matchInfo = match;

        teamId = result.getTeamId();
        win = result.getWin();
        baronKills = result.getObjectives().getBaron().getKills();
        championKills = result.getObjectives().getChampion().getKills();
        dragonKills = result.getObjectives().getDragon().getKills();
        inhibitorKills = result.getObjectives().getInhibitor().getKills();
        riftHeraldKills = result.getObjectives().getRiftHerald().getKills();
        towerKills = result.getObjectives().getTower().getKills();
    }
}
