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
    private String riotIdName;
    private String riotIdTagline;
    private int profileIcon;

    private String summonerId;
    private int summonerLevel;
    private String summonerName;

    private int participantId;
    private int teamId;

    // 챔피언 정보
    private int championId;
    private String championName;
    private int champLevel;
    private int champExperience;
    private int championTransform;
    private PerksApiResult perks;

    // 게임 종료 여부
    private boolean win;
    private boolean gameEndedInEarlySurrender;
    private boolean gameEndedInSurrender;

    private int inhibitorKills;
    private int inhibitorTakedowns;
    private int inhibitorsLost;

    private int nexusKills;
    private int nexusTakedowns;
    private int nexusLost;

    private boolean teamEarlySurrendered ;

    // 게임 정보 - 킬, 데스, 어시
    private int kills;
    private int deaths;
    private int assists;

    private int bountyLevel;
    private int killingSprees;
    private int largestKillingSpree;
    private int largestMultiKill;
    private int doubleKills;
    private int tripleKills;
    private int quadraKills;
    private int pentaKills;
    private int unrealKills;

    // 게임 정보 - 데미지
    private int damageDealtToBuildings;
    private int damageDealtToObjectives;
    private int damageDealtToTurrets;
    private int damageSelfMitigated;
    private int largestCriticalStrike;

    private int totalDamageDealt;
    private int totalDamageDealtToChampions;
    private int totalDamageShieldedOnTeammates;
    private int totalDamageTaken;

    private int magicDamageDealt;
    private int magicDamageDealtToChampions;
    private int magicDamageTaken;

    private int physicalDamageDealt;
    private int physicalDamageDealtToChampions;
    private int physicalDamageTaken;

    private int timeCCingOthers;
    private int timePlayed;
    private int totalHeal;
    private int totalHealsOnTeammates;
    private int totalMinionsKilled;
    private int totalTimeCCDealt;
    private int totalTimeSpentDead;
    private int totalUnitsHealed;
    private int trueDamageDealt;
    private int trueDamageDealtToChampions;
    private int trueDamageTaken;

    // 오브젝트, 타워
    private int baronKills;
    private int dragonKills;
    private int objectivesStolen;
    private int objectivesStolenAssists;

    private int turretKills;
    private int turretTakedowns;
    private int turretsLost;

    // 데미지

    // 생존
    private int longestTimeSpentLiving;

    // 시야
    private int sightWardsBoughtInGame;
    private int detectorWardsPlaced;

    private int visionScore;
    private int visionWardsBoughtInGame;
    private int wardsKilled;
    private int wardsPlaced;

    // 퍼블
    private boolean firstBloodAssist;
    private boolean firstBloodKill;
    private boolean firstTowerAssist;
    private boolean firstTowerKill;

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
    private int goldEarned;
    private int goldSpent;
    private int neutralMinionsKilled;

    // 아이템
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int itemsPurchased;
    private int consumablesPurchased;

    // 스펠
    private int spell1Casts;
    private int spell2Casts;
    private int spell3Casts;
    private int spell4Casts;

    private int summoner1Casts;
    private int summoner1Id;
    private int summoner2Casts;
    private int summoner2Id;
}
