package duo.gg.server.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MatchTeamDto {
    // 블루/레드
    private int teamId;
    // 승리 여부
    private boolean isWin;
    // 타워 부순 수
    private int towerKills;
    // 바론 먹은 수
    private int baronKills;
    // 용 먹은 수
    private int dragonKills;
    // 전체 킬
    private int totalKills;
    // 전체 골드
    private int totalGold;
    // 전체 딜량
    private int totalDamageDealtToChampions;
    // 전체 와드 처치 수
    private int totalWardKills;
    // 전체 받은 피해량
    private int totalDamageTaken;
    // 전체 CS
    private int totalMinionsKilled;
    // 참여자별 정보 리스트
    private List<ParticipantDetailDto> participants = new ArrayList<>();
}
