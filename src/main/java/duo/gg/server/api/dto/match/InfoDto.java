package duo.gg.server.api.dto.match;


import duo.gg.server.api.constant.GameMode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class InfoDto {
    // Unix timestamp for when the game is created on the game server (i.e., the loading screen).
    public Long gameCreation;

    // Prior to patch 11.20, this field returns the game length in milliseconds calculated from gameEndTimestamp - gameStartTimestamp.
    // Post patch 11.20, this field returns the max timePlayed of any participant in the game in seconds,
    // which makes the behavior of this field consistent with that of match-v4.
    // The best way to handling the change in this field is to treat the value as milliseconds
    // if the gameEndTimestamp field isn't in the response and to treat the value as seconds
    // if gameEndTimestamp is in the response.
    public Long gameDuration;

    // Unix timestamp for when match ends on the game server.
    // This timestamp can occasionally be significantly longer than when the match "ends".
    // The most reliable way of determining the timestamp for the end of the match
    // would be to add the max time played of any participant to the gameStartTimestamp.
    // This field was added to match-v5 in patch 11.20 on Oct 5th, 2021.
    public Long gameEndTimestamp;

    public Long gameId;

    // Refer to the Game Constants documentation.
    // https://developer.riotgames.com/docs/lol#general_game-constants
    public GameMode gameMode;

    public String gameName;

    // Unix timestamp for when match starts on the game server.
    public Long gameStartTimestamp;

    public String gameType;

    // The first two parts can be used to determine the patch a game was played on.
    public String gameVersion;

    // 	Refer to the Game Constants documentation.
    public int mapId;

    public List<ParticipantDto> participants;

    // Platform where the match was played.
    public String platformId;

    // Refer to the Game Constants documentation.
    public int queueId;

    public List<TeamDto> teams;

    // Tournament code used to generate the match. This field was added to match-v5 in patch 11.13 on June 23rd, 2021.
    public String tournamentCode;

}
