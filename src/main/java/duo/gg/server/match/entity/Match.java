package duo.gg.server.match.entity;

import duo.gg.server.api.constant.GameModeEnum;
import duo.gg.server.api.dto.match.MatchApiResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @Column(name = "match_id")
    private String id;
    private String dataVersion;

    private Long gameCreation;
    private Long gameDuration;
    private Long gameEndTimestamp;
    private Long gameId;

    @Enumerated(EnumType.STRING)
    private GameModeEnum gameMode;
    private String gameName;
    private Long gameStartTimestamp;
    private String gameType;
    private String gameVersion;
    private int mapId;
    private String platformId;
    private int queueId;
    private String tournamentCode;


    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Team> teams = new ArrayList<>();

    public Match(MatchApiResult result) {
        id = result.getMetadata().getMatchId();
        dataVersion = result.getMetadata().getDataVersion();
        gameCreation = result.getInfo().getGameCreation();
        gameEndTimestamp = result.getInfo().getGameEndTimestamp();
        gameDuration = result.getInfo().getGameDuration();
        gameId = result.getInfo().getGameId();
        gameMode = result.getInfo().getGameMode();
        gameName = result.getInfo().getGameName();
        gameStartTimestamp = result.getInfo().getGameStartTimestamp();
        gameType = result.getInfo().getGameType();
        gameVersion = result.getInfo().getGameVersion();
        mapId = result.getInfo().getMapId();
        platformId = result.getInfo().getPlatformId();
        queueId = result.getInfo().getQueueId();
        tournamentCode = result.getInfo().getTournamentCode();

        participants = result.getInfo()
                .getParticipants()
                .stream()
                .map((participant) -> new Participant(participant, this))
                .collect(Collectors.toList());

        teams = result.getInfo()
                .getTeams()
                .stream().map((team) -> new Team(team, this))
                .collect(Collectors.toList());
    }
}
