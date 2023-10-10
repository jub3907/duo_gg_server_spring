package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// LEAGUE-V4, /lol/league/v4/challengerleagues/by-queue/{queue}
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueListApiResult {

    private String leagueId;

    private List<LeagueItemApiResult> entries;

    private String tier;

    private String name;

    private String queue;
}
