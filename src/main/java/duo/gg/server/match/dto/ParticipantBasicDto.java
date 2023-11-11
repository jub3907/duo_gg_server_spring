package duo.gg.server.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantBasicDto {
    private String summonerName;
    private Integer championId;
    private String puuid;
}
