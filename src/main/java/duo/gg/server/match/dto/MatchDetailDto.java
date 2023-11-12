package duo.gg.server.match.dto;

import duo.gg.server.constant.TeamId;
import duo.gg.server.match.entity.MatchInfo;
import duo.gg.server.match.entity.Participant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatchDetailDto {
    private String matchId;

    // 전체 플레이 시간
    private Long gameCreation;
    private Long gameDuration;
    private Integer winner;

    private List<ParticipantDetailDto> blue = new ArrayList<>();
    private List<ParticipantDetailDto> red = new ArrayList<>();

    private PerkDto perk;

    public MatchDetailDto(MatchInfo match, String puuid) {
        matchId = match.getId();
        gameCreation = match.getGameCreation();
        gameDuration = match.getGameDuration();
        if (match.getParticipants().get(0).getWin()) {
        } else {
            winner = match.getParticipants().get(0).getTeamId();
        }

        for (Participant participant : match.getParticipants()) {
            if (participant.getTeamId() == TeamId.BLUE) {
                blue.add(new ParticipantDetailDto(participant));
            } else {
                red.add(new ParticipantDetailDto(participant));
            }

            if (participant.getPuuid().equals(puuid)) {
                perk = new PerkDto(participant.getPerks());
            }

            if (participant.getWin()) {
                winner = participant.getTeamId();
            }
        }
    }
}
