package duo.gg.server.api.dto.summoner;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SummonerDto {

    // Encrypted account ID. Max length 56 characters.
    public String accountId;

    // 	ID of the summoner icon associated with the summoner.
    public int profileIconId;

    // Date summoner was last modified specified as epoch milliseconds.
    // The following events will update this timestamp: profile icon change,
    // playing the tutorial or advanced tutorial, finishing a game, summoner name change
    public Long revisionDate;

    // Summoner name.
    public String name;

    // Encrypted summoner ID. Max length 63 characters.
    public String id;

    // Encrypted PUUID. Exact length of 78 characters.
    public String puuid;

    // Summoner level associated with the summoner.
    public Long summonerLevel;
}
