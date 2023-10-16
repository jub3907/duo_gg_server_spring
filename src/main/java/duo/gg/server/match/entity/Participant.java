package duo.gg.server.match.entity;

import duo.gg.server.api.dto.match.ParticipantApiResult;
import duo.gg.server.api.dto.perk.PerksApiResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Participant {
    @Id @GeneratedValue
    @Column(name = "participant_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private Match match;

    @Embedded
    private Perk perks;

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

    public Participant(ParticipantApiResult result, Match match) {
        this.match = match;

        perks = new Perk(result.getPerks());
        puuid = result.getPuuid();
        riotIdName = result.getRiotIdName();
        riotIdTagline = result.getRiotIdTagline();
        profileIcon = result.getProfileIcon();

        summonerId = result.getSummonerId();
        summonerLevel = result.getSummonerLevel();
        summonerName = result.getSummonerName();

        participantId = result.getParticipantId();
        teamId = result.getTeamId();

        championId = result.getChampionId();
        championName = result.getChampionName();
        champLevel = result.getChampLevel();
        champExperience = result.getChampExperience();
        championTransform = result.getChampionTransform();

        win = result.isWin();
        gameEndedInEarlySurrender = result.isGameEndedInEarlySurrender();
        gameEndedInSurrender = result.isGameEndedInSurrender();

        inhibitorKills = result.getInhibitorKills();
        inhibitorTakedowns = result.getInhibitorTakedowns();
        inhibitorsLost = result.getInhibitorsLost();

        nexusKills = result.getNexusKills();
        nexusTakedowns = result.getNexusTakedowns();
        nexusLost = result.getNexusLost();

        teamEarlySurrendered = result.isTeamEarlySurrendered();

        kills = result.getKills();
        deaths = result.getDeaths();
        assists = result.getAssists();

        bountyLevel = result.getBountyLevel();
        killingSprees = result.getKillingSprees();
        largestKillingSpree = result.getLargestKillingSpree();
        largestMultiKill = result.getLargestMultiKill();
        doubleKills = result.getDoubleKills();
        tripleKills = result.getTripleKills();
        quadraKills = result.getQuadraKills();
        pentaKills = result.getPentaKills();
        unrealKills = result.getUnrealKills();

        damageDealtToBuildings = result.getDamageDealtToBuildings();
        damageDealtToObjectives = result.getDamageDealtToObjectives();
        damageDealtToTurrets = result.getDamageDealtToTurrets();
        damageSelfMitigated = result.getDamageSelfMitigated();
        largestCriticalStrike = result.getLargestCriticalStrike();

        totalDamageDealt = result.getTotalDamageDealt();
        totalDamageDealtToChampions = result.getTotalDamageDealtToChampions();
        totalDamageShieldedOnTeammates = result.getTotalDamageShieldedOnTeammates();
        totalDamageTaken = result.getTotalDamageTaken();

        magicDamageDealt = result.getMagicDamageDealt();
        magicDamageDealtToChampions = result.getMagicDamageDealtToChampions();
        magicDamageTaken = result.getMagicDamageTaken();

        physicalDamageDealt = result.getPhysicalDamageDealt();
        physicalDamageDealtToChampions = result.getPhysicalDamageDealtToChampions();
        physicalDamageTaken = result.getPhysicalDamageTaken();

        timeCCingOthers = result.getTimeCCingOthers();
        timePlayed = result.getTimePlayed();
        totalHeal = result.getTotalHeal();
        totalHealsOnTeammates = result.getTotalHealsOnTeammates();
        totalMinionsKilled = result.getTotalMinionsKilled();
        totalTimeCCDealt = result.getTotalTimeCCDealt();
        totalTimeSpentDead = result.getTotalTimeSpentDead();
        totalUnitsHealed = result.getTotalUnitsHealed();
        trueDamageDealt = result.getTrueDamageDealt();
        trueDamageDealtToChampions = result.getTrueDamageDealtToChampions();
        trueDamageTaken = result.getTrueDamageTaken();

        baronKills = result.getBaronKills();
        dragonKills = result.getDragonKills();
        objectivesStolen = result.getObjectivesStolen();
        objectivesStolenAssists = result.getObjectivesStolenAssists();

        turretKills = result.getTurretKills();
        turretTakedowns = result.getTurretTakedowns();
        turretsLost = result.getTurretsLost();

        longestTimeSpentLiving = result.getLongestTimeSpentLiving();

        sightWardsBoughtInGame = result.getSightWardsBoughtInGame();
        detectorWardsPlaced = result.getDetectorWardsPlaced();

        visionScore = result.getVisionScore();
        visionWardsBoughtInGame = result.getVisionWardsBoughtInGame();
        wardsKilled = result.getWardsKilled();
        wardsPlaced = result.getWardsPlaced();

        firstBloodAssist = result.isFirstBloodAssist();
        firstBloodKill = result.isFirstBloodKill();
        firstTowerAssist = result.isFirstTowerAssist();
        firstTowerKill = result.isFirstTowerKill();

        lane = result.getLane();
        role = result.getRole();

        individualPosition = result.getIndividualPosition();
        teamPosition = result.getTeamPosition();

        goldEarned = result.getGoldEarned();
        goldSpent = result.getGoldSpent();
        neutralMinionsKilled = result.getNeutralMinionsKilled();

        item0 = result.getItem0();
        item1 = result.getItem1();
        item2 = result.getItem2();
        item3 = result.getItem3();
        item4 = result.getItem4();
        item5 = result.getItem5();
        item6 = result.getItem6();
        itemsPurchased = result.getItemsPurchased();
        consumablesPurchased = result.getConsumablesPurchased();

        spell1Casts = result.getSpell1Casts();
        spell2Casts = result.getSpell2Casts();
        spell3Casts = result.getSpell3Casts();
        spell4Casts = result.getSpell4Casts();

        summoner1Casts = result.getSummoner1Casts();
        summoner1Id = result.getSummoner1Id();

        summoner2Casts = result.getSummoner2Casts();
        summoner2Id = result.getSummoner2Id();
    }
}
