package duo.gg.server.match.entity;

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

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Team> teams = new ArrayList<>();

    Match(MatchApiResult result) {
        id = result.getMetadata().getMatchId();
        dataVersion = result.getMetadata().getDataVersion();

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
