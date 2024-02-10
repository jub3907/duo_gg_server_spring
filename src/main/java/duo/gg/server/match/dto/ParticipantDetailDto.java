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
    private String riotIdGameName;
    private String riotIdTagLine;
    private String puuid;
    // 티어
    //TODO: 티어 추가

    // 팀
    private Integer teamId;

    // 챔피언 레벨
    private Integer champLevel;
    // 챔피언 이름
    private String championName;
    // 챔피언 아이디
    private Integer championId;
    // 스펠 1~4
    private Integer summoner1Id;
    private Integer summoner2Id;
    // 아이템 0~6
    private Integer item0;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;

    private Boolean isWin;
    // 킬
    // 데스
    // 어시스트
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    // CS
    private Integer totalMinionsKilled;
    // 골드획득량
    private Integer goldEarned;
    // 피해량
    private Integer totalDamageDealtToChampions;
    // 받은피해량
    private Integer totalDamageTaken;


    private Integer baronKills;
    private Integer dragonKills;
    private Integer turretKills;

    // 시야 점수
    private Integer visionScore;
    // 와드 설치
    private Integer wardsPlaced;
    private Integer detectorWardsPlaced;

    public ParticipantDetailDto(Participant participant) {
        teamPosition = participant.getTeamPosition();
        riotIdGameName = participant.getRiotIdGameName();
        riotIdTagLine = participant.getRiotIdTagline();
        puuid = participant.getPuuid();
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

        isWin = participant.getWin();

        baronKills = participant.getBaronKills();
        dragonKills = participant.getDragonKills();
        turretKills = participant.getTurretKills();

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
