package duo.gg.server.match.dto;

import duo.gg.server.constant.TeamId;
import duo.gg.server.match.entity.Match;
import duo.gg.server.match.entity.Participant;

import java.util.ArrayList;
import java.util.List;

public class MatchBasicDto {
    // 플레이타임
    private Long gameDuration;
    // 언제 플레이 했는지
    private Long gameCreation;
    // 랭크 타입
    private String gameType;
    private String gameMode;
    // 승패 여부
    private boolean isWin;

    // 챔피언 이름
    private String championName;
    // 챔피언 아이디
    private int championId;
    // 챔피언 레벨
    private int champLevel;

    // 라인
    private String teamPosition;
    // 킬,
    // 데스
    // 어시
    private int kills;
    private int deaths;
    private int assists;

    // 아이템 0 ~ 6
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    // 스펠 1, 2
    private int summoner1Id;
    private int summoner2Id;

    // 팀 전체 킬
    // 골드 획득량
    private int goldEarned;
    // CS
    private int totalMinionsKilled;

    private List<ParticipantBasicDto> blue = new ArrayList<>();
    private List<ParticipantBasicDto> red = new ArrayList<>();


    // 블루, 레드팀 참여자 리스트
    // 닉네임
    // 챔피언 아이디

    public MatchBasicDto(Match match, String puuid) {
        gameDuration = match.getGameDuration();
        gameCreation = match.getGameCreation();

        gameType = match.getGameType();
        gameMode = match.getGameMode().name();

        for (Participant participant : match.getParticipants()) {
            if (participant.getTeamId() == TeamId.BLUE) {
                blue.add(new ParticipantBasicDto(participant.getRiotIdName(), participant.getChampionId()));
            } else {
                red.add(new ParticipantBasicDto(participant.getRiotIdName(), participant.getChampionId()));
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

                isWin = participant.isWin();
            }
        }
    }
}
