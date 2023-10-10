package duo.gg.server.api.dto.summoner;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SummonerDto {

    // Encrypted account ID. Max length 56 characters.
    private String accountId;

    // 	ID of the summoner icon associated with the summoner.
    private int profileIconId;

    // Date summoner was last modified specified as epoch milliseconds.
    // The following events will update this timestamp: profile icon change,
    // playing the tutorial or advanced tutorial, finishing a game, summoner name change
    private Long revisionDate;

    // Summoner name.
    private String name;

    // Encrypted summoner ID. Max length 63 characters.
    private String id;

    // Encrypted PUUID. Exact length of 78 characters.
    private String puuid;

    // Summoner level associated with the summoner.
    private Long summonerLevel;
}
