package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

// LEAGUE-V4, /lol/league/v4/challengerleagues/by-queue/{queue}
@Getter
@AllArgsConstructor
public class LeagueListDto {

    public String leagueId;

    public List<LeagueItemDto> entries;

    public String tier;

    public String name;

    public String queue;
}
