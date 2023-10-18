package duo.gg.server.match.dto;

import duo.gg.server.match.entity.Participant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDetailDto {
    // 라인
    private String teamPosition;
    // 이름
    private String riotIdName;
    // 티어
    //TODO: 티어 추가

    // 팀
    private int teamId;

    // 챔피언 레벨
    private int champLevel;
    // 챔피언 이름
    private String championName;
    // 챔피언 아이디
    private int championId;
    // 스펠 1~4
    private int summoner1Id;
    private int summoner2Id;
    // 아이템 0~6
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;

    // 킬
    // 데스
    // 어시스트
    private int kills;
    private int deaths;
    private int assists;
    // CS
    private int totalMinionsKilled;
    // 골드획득량
    private int goldEarned;
    // 피해량
    private int totalDamageDealtToChampions;
    // 받은피해량
    private int totalDamageTaken;

    // 시야 점수
    private int visionScore;
    // 와드 설치
    private int wardsPlaced;
    private int detectorWardsPlaced;

    public ParticipantDetailDto(Participant participant) {
        teamPosition = participant.getTeamPosition();
        riotIdName = participant.getRiotIdName();
        teamId = participant.getTeamId();
        champLevel = participant.getChampLevel();
        championName = participant.getChampionName();
        championId = participant.getChampionId();
        summoner1Id = participant.getSummoner1Id();
        summoner2Id = participant.getSummoner2Id();
        item0 = participant.getItem0();
        item1 = participant.getItem1();
        item2 = participant.getItem2();
        item3 = participant.getItem3();
        item4 = participant.getItem4();
        item5 = participant.getItem5();
        item6 = participant.getItem6();
        kills = participant.getKills();
        deaths = participant.getDeaths();
        assists = participant.getAssists();
        totalMinionsKilled = participant.getTotalMinionsKilled();
        goldEarned = participant.getGoldEarned();
        totalDamageDealtToChampions = participant.getTotalDamageDealtToChampions();
        totalDamageTaken = participant.getTotalDamageTaken();
        visionScore = participant.getVisionScore();
        wardsPlaced = participant.getWardsPlaced();
        detectorWardsPlaced = participant.getDetectorWardsPlaced();
    }
}
