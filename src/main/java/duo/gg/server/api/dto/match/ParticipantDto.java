package duo.gg.server.api.dto.match;

import duo.gg.server.api.dto.perk.PerksDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParticipantDto {
    // 플레이어, 참여자 정보
    public String puuid;
    public String riotIdName;
    public String riotIdTagline;
    public int profileIcon;

    public String summonerId;
    public int summonerLevel;
    public String summonerName;

    public int participantId;
    public int teamId;

    // 챔피언 정보
    public int championId;
    public String championName;
    public int champLevel;
    public int champExperience;
    public int championTransform;
    public PerksDto perks;

    // 게임 종료 여부
    public boolean win;
    public boolean gameEndedInEarlySurrender;
    public boolean gameEndedInSurrender;

    public int inhibitorKills;
    public int inhibitorTakedowns;
    public int inhibitorsLost;

    public int nexusKills;
    public int nexusTakedowns;
    public int nexusLost;

    public boolean teamEarlySurrendered ;

    // 게임 정보 - 킬, 데스, 어시
    public int kills;
    public int deaths;
    public int assists;

    public int bountyLevel;
    public int killingSprees;
    public int largestKillingSpree;
    public int largestMultiKill;
    public int doubleKills;
    public int tripleKills;
    public int quadraKills;
    public int pentaKills;
    public int unrealKills;

    // 게임 정보 - 데미지
    public int damageDealtToBuildings;
    public int damageDealtToObjectives;
    public int damageDealtToTurrets;
    public int damageSelfMitigated;
    public int largestCriticalStrike;

    public int totalDamageDealt;
    public int totalDamageDealtToChampions;
    public int totalDamageShieldedOnTeammates;
    public int totalDamageTaken;

    public int magicDamageDealt;
    public int magicDamageDealtToChampions;
    public int magicDamageTaken;

    public int physicalDamageDealt;
    public int physicalDamageDealtToChampions;
    public int physicalDamageTaken;

    public int timeCCingOthers;
    public int timePlayed;
    public int totalHeal;
    public int totalHealsOnTeammates;
    public int totalMinionsKilled;
    public int totalTimeCCDealt;
    public int totalTimeSpentDead;
    public int totalUnitsHealed;
    public int trueDamageDealt;
    public int trueDamageDealtToChampions;
    public int trueDamageTaken;

    // 오브젝트, 타워
    public int baronKills;
    public int dragonKills;
    public int objectivesStolen;
    public int objectivesStolenAssists;

    public int turretKills;
    public int turretTakedowns;
    public int turretsLost;

    // 데미지

    // 생존
    public int longestTimeSpentLiving;

    // 시야
    public int sightWardsBoughtInGame;
    public int detectorWardsPlaced;

    public int visionScore;
    public int visionWardsBoughtInGame;
    public int wardsKilled;
    public int wardsPlaced;

    // 퍼블
    public boolean firstBloodAssist;
    public boolean firstBloodKill;
    public boolean firstTowerAssist;
    public boolean firstTowerKill;

    // 라인
    public String lane;
    public String role;
    // Both individualPosition and teamPosition are computed by the game server and
    // are different versions of the most likely position played by a player.
    // The individualPosition is the best guess for which position the player actually played in isolation of anything else.
    // The teamPosition is the best guess for which position the player actually played
    // if we add the constraint that each team must have one top player, one jungle, one middle, etc.
    // Generally the recommendation is to use the teamPosition field over the individualPosition field.
    public String individualPosition;
    public String teamPosition;

    // 골드
    public int goldEarned;
    public int goldSpent;
    public int neutralMinionsKilled;

    // 아이템
    public int item0;
    public int item1;
    public int item2;
    public int item3;
    public int item4;
    public int item5;
    public int item6;
    public int itemsPurchased;
    public int consumablesPurchased;

    // 스펠
    public int spell1Casts;
    public int spell2Casts;
    public int spell3Casts;
    public int spell4Casts;

    public int summoner1Casts;
    public int summoner1Id;
    public int summoner2Casts;
    public int summoner2Id;
}
