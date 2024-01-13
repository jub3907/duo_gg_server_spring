package duo.gg.server.api.dto.match;

import duo.gg.server.api.dto.perk.PerksApiResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantApiResult {
    // 플레이어, 참여자 정보
    private String puuid;
    private String riotIdGameName;
    private String riotIdTagline;
    private Integer profileIcon;

    private String summonerId;
    private Integer summonerLevel;
    private String summonerName;

    private Integer participantId;
    private Integer teamId;

    // 챔피언 정보
    private Integer championId;
    private String championName;
    private Integer champLevel;
    private Integer champExperience;
    private Integer championTransform;
    private PerksApiResult perks;

    // 게임 종료 여부
    private Boolean win;
    private Boolean gameEndedInEarlySurrender;
    private Boolean gameEndedInSurrender;

    private Integer inhibitorKills;
    private Integer inhibitorTakedowns;
    private Integer inhibitorsLost;

    private Integer nexusKills;
    private Integer nexusTakedowns;
    private Integer nexusLost;

    private Boolean teamEarlySurrendered ;

    // 게임 정보 - 킬, 데스, 어시
    private Integer kills;
    private Integer deaths;
    private Integer assists;

    private Integer bountyLevel;
    private Integer killingSprees;
    private Integer largestKillingSpree;
    private Integer largestMultiKill;
    private Integer doubleKills;
    private Integer tripleKills;
    private Integer quadraKills;
    private Integer pentaKills;
    private Integer unrealKills;

    // 게임 정보 - 데미지
    private Integer damageDealtToBuildings;
    private Integer damageDealtToObjectives;
    private Integer damageDealtToTurrets;
    private Integer damageSelfMitigated;
    private Integer largestCriticalStrike;

    private Integer totalDamageDealt;
    private Integer totalDamageDealtToChampions;
    private Integer totalDamageShieldedOnTeammates;
    private Integer totalDamageTaken;

    private Integer magicDamageDealt;
    private Integer magicDamageDealtToChampions;
    private Integer magicDamageTaken;

    private Integer physicalDamageDealt;
    private Integer physicalDamageDealtToChampions;
    private Integer physicalDamageTaken;

    private Integer timeCCingOthers;
    private Integer timePlayed;
    private Integer totalHeal;
    private Integer totalHealsOnTeammates;
    private Integer totalMinionsKilled;
    private Integer totalTimeCCDealt;
    private Integer totalTimeSpentDead;
    private Integer totalUnitsHealed;
    private Integer trueDamageDealt;
    private Integer trueDamageDealtToChampions;
    private Integer trueDamageTaken;

    // 오브젝트, 타워
    private Integer baronKills;
    private Integer dragonKills;
    private Integer objectivesStolen;
    private Integer objectivesStolenAssists;

    private Integer turretKills;
    private Integer turretTakedowns;
    private Integer turretsLost;

    // 데미지

    // 생존
    private Integer longestTimeSpentLiving;

    // 시야
    private Integer sightWardsBoughtInGame;
    private Integer detectorWardsPlaced;

    private Integer visionScore;
    private Integer visionWardsBoughtInGame;
    private Integer wardsKilled;
    private Integer wardsPlaced;

    // 퍼블
    private Boolean firstBloodAssist;
    private Boolean firstBloodKill;
    private Boolean firstTowerAssist;
    private Boolean firstTowerKill;

    // 라인
    private String lane;
    private String role;
    // Both individualPosition and teamPosition are computed by the game server and
    // are different versions of the most likely position played by a player.
    // The individualPosition is the best guess for which position the player actually played in isolation of anything else.
    // The teamPosition is the best guess for which position the player actually played
    // if we add the constraint that each team must have one top player, one jungle, one middle, etc.
    // Generally the recommendation is to use the teamPosition field over the individualPosition field.
    private String individualPosition;
    private String teamPosition;

    // 골드
    private Integer goldEarned;
    private Integer goldSpent;
    private Integer neutralMinionsKilled;

    // 아이템
    private Integer item0;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;
    private Integer itemsPurchased;
    private Integer consumablesPurchased;

    // 스펠
    private Integer spell1Casts;
    private Integer spell2Casts;
    private Integer spell3Casts;
    private Integer spell4Casts;

    private Integer summoner1Casts;
    private Integer summoner1Id;
    private Integer summoner2Casts;
    private Integer summoner2Id;
}
