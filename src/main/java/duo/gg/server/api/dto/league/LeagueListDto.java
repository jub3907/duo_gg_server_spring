package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

// LEAGUE-V4, /lol/league/v4/challengerleagues/by-queue/{queue}
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueListDto {

    private String leagueId;

    private List<LeagueItemDto> entries;

    private String tier;

    private String name;

    private String queue;
}
