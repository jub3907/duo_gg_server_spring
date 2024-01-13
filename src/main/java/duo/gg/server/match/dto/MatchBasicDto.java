package duo.gg.server.match.dto;

import duo.gg.server.constant.TeamId;
import duo.gg.server.match.entity.MatchInfo;
import duo.gg.server.match.entity.Participant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatchBasicDto {
    private String matchId;
    // 플레이타임
    private Long gameDuration;
    // 언제 플레이 했는지
    private Long gameCreation;
    // 랭크 타입
    private String gameType;
    private String gameMode;
    // 승패 여부
    private Boolean isWin;

    // 챔피언 이름
    private String championName;
    // 챔피언 아이디
    private Integer championId;
    // 챔피언 레벨
    private Integer champLevel;

    // 라인
    private String teamPosition;
    // 킬,
    // 데스
    // 어시
    private Integer kills;
    private Integer deaths;
    private Integer assists;

    // 아이템 0 ~ 6
    private Integer item0;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;
    // 스펠 1, 2
    private Integer summoner1Id;
    private Integer summoner2Id;

    // 팀 전체 킬
    // 골드 획득량
    private Integer goldEarned;
    // CS
    private Integer totalMinionsKilled;

    private Integer totalDamageDealtToChampions;

    private List<ParticipantBasicDto> blue = new ArrayList<>();
    private List<ParticipantBasicDto> red = new ArrayList<>();


    // 블루, 레드팀 참여자 리스트
    // 닉네임
    // 챔피언 아이디
    // puuid

    public MatchBasicDto(MatchInfo match, String puuid) {
        matchId = match.getId();
        gameDuration = match.getGameDuration();
        gameCreation = match.getGameCreation();

        gameType = match.getGameType();
        gameMode = match.getGameMode().name();

        for (Participant participant : match.getParticipants()) {
            if (participant.getTeamId() == TeamId.BLUE) {
                blue.add(new ParticipantBasicDto(participant.getSummonerName(), participant.getRiotIdTagline(), participant.getChampionId(), participant.getPuuid()));
            } else {
                red.add(new ParticipantBasicDto(participant.getSummonerName(), participant.getRiotIdTagline(), participant.getChampionId(), participant.getPuuid()));
            }

            if (participant.getPuuid().equals(puuid)) {
                championName = participant.getChampionName();
                championId = participant.getChampionId();
                champLevel = participant.getChampLevel();
                teamPosition = participant.getTeamPosition();
                kills = participant.getKills();
                deaths = participant.getDeaths();
                assists = participant.getAssists();
                item0 = participant.getItem0();
                item1 = participant.getItem1();
                item2 = participant.getItem2();
                item3 = participant.getItem3();
                item4 = participant.getItem4();
                item5 = participant.getItem5();
                item6 = participant.getItem6();
                summoner1Id = participant.getSummoner1Id();
                summoner2Id = participant.getSummoner2Id();
                goldEarned = participant.getGoldEarned();
                totalMinionsKilled = participant.getTotalMinionsKilled();
                totalDamageDealtToChampions = participant.getTotalDamageDealtToChampions();

                isWin = participant.getWin();
            }
        }
    }
}
