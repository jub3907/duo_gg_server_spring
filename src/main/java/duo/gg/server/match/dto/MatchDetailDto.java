package duo.gg.server.match.dto;

import duo.gg.server.constant.TeamId;
import duo.gg.server.match.entity.Match;
import duo.gg.server.match.entity.Participant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatchDetailDto {
    // 전체 플레이 시간
    private Long gameDuration;
    private Integer winner;

    private List<ParticipantDetailDto> blue;
    private List<ParticipantDetailDto> red;

    private PerkDto perk;

    public MatchDetailDto(Match match, String puuid) {
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
