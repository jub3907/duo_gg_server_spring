package duo.gg.server.api.service;

import duo.gg.server.api.constant.UriEnum;
import duo.gg.server.api.dto.account.AccountDto;
import duo.gg.server.api.dto.account.ActiveShardDto;
import duo.gg.server.api.dto.champion.ChampionInfoDto;
import duo.gg.server.api.dto.championMastery.ChampionMasteryDto;
import duo.gg.server.api.dto.league.LeagueEntryDto;
import duo.gg.server.api.dto.league.LeagueListDto;
import duo.gg.server.api.dto.match.MatchDto;
import duo.gg.server.api.dto.match.MatchTimelineDto;
import duo.gg.server.api.dto.summoner.SummonerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ApiService {


// ACCOUNT

    /**
     * call /riot/account/v1/accounts/by-puuid/{puuid}
     * @param puuid puuid
     * @return AccountDto
     */
    public AccountDto getAccountByPuuid(String puuid) {
        return null;
    }

    /**
     * call /riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}
     * When querying for a player by their riot id, the gameName and tagLine query params are required.
     * However not all accounts have a gameName and tagLine associated so these fields may not be included in the response.
     * @param tagLine tagLine
     * @param gameName gameName
     * @return AccountDto
     */
    public AccountDto getAccountByRiotId(String tagLine, String gameName) {
        return null;
    }

    /**
     * call /riot/account/v1/accounts/me
     * @param Authorization AccessToken
     * @return AccountDto
     */
    public AccountDto getAccountByAccessToken(String Authorization) {
        return null;
    }

    /**
     * call /riot/account/v1/active-shards/by-game/{game}/by-puuid/{puuid}
     * @param game game
     * @param puuid puuid
     * @return ActiveShardDto
     */
    public ActiveShardDto getActiveShard(String game, String puuid) {
        return null;
    }

// CHAMPION-MASTERY

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}
     * @param encryptedPUUID encryptedPUUID
     * @return
     */
    public List<ChampionMasteryDto> getChampionMasteriesByPuuid(String encryptedPUUID) {
        return null;
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/by-champion/{championId}
     * @param encryptedPUUID encryptedPUUID
     * @param championId championId
     * @return
     */
    public ChampionMasteryDto getChampionMasteryByPuuidAndChampionId(String encryptedPUUID, String championId) {
        return null;
    }

    /**
     * /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/top
     * @param encryptedPUUID encryptedPUUID
     * @param count default 3
     * @return
     */
    public List<ChampionMasteryDto> getChampionMasteriesByPuuidDescending(String encryptedPUUID, int count) {
        return null;
    }

    public List<ChampionMasteryDto> getChampionMasteriesByPuuidDescending(String encryptedPUUID) {
        return getChampionMasteriesByPuuidDescending(encryptedPUUID, 3);
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}
     * @param encryptedSummonerId encryptedSummonerId
     * @param count count
     * @return
     */
    public List<ChampionMasteryDto> getChampionMasteriesBySummonerId(String encryptedSummonerId, int count) {
        return null;
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}
     * @param encryptedSummonerId encrypted summoner id
     * @param championId champion's id
     * @return Champion Mastery Dto
     */
    public ChampionMasteryDto getChampionMasteryBySummonerIdAndChampionId(String encryptedSummonerId, String championId) {
        return null;
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/top
     * @param encryptedSummonerId encrypted summoner id
     * @param count default 3
     * @return List of Champion Mastery Dto
     */
    public List<ChampionMasteryDto> getChampionMasteriesBySummonerIdDescending(String encryptedSummonerId, int count) {
        return null;
    }

    public List<ChampionMasteryDto> getChampionMasteriesBySummonerIdDescending(String encryptedSummonerId) {
        return getChampionMasteriesBySummonerIdDescending(encryptedSummonerId, 3);
    }

    /**
     * call /lol/champion-mastery/v4/scores/by-puuid/{encryptedPUUID}
     * @param encryptedPUUID encrypted puuid
     * @return Integer
     */
    public Integer getChampionMasteryScoresByPuuid(String encryptedPUUID) {
        return null;
    }

    /**
     * call /lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}
     * @param encryptedSummonerId encrypted summoner id
     * @return Integer
     */
    public Integer getChampionMasteryScoresBySummonerId(String encryptedSummonerId) {
        return null;
    }

// CHAMPION

    /**
     * call /lol/platform/v3/champion-rotations
     * @return Champion Info Dto
     */
    public ChampionInfoDto getChampionRotation() {
        return null;
    }

// LEAGUE-EXP

    /**
     * call /lol/league-exp/v4/entries/{queue}/{tier}/{division}
     * @param queue queue
     * @param tier tier
     * @param division division
     * @return Set of League Entry Dto
     */
    public Set<LeagueEntryDto> getLeagueEntriesExp(String queue, String tier, String division) {
        return null;
    }

// LEAGUE


    /**
     * call /lol/league/v4/leagues/{leagueId}
     * @param leagueId league's id value
     * @return League List Dto
     */
    public LeagueListDto getLeaguesByLeagueId(String leagueId) {
        return null;
    }

    /**
     * call /lol/league/v4/entries/by-summoner/{encryptedSummonerId}
     * @param encryptedSummonerId encrypted summoner id
     * @return Set of League Entry Dto
     */
    public Set<LeagueEntryDto> getLeagueEntriesBySummonerId(String encryptedSummonerId) {
        return null;
    }

    /**
     * call /lol/league/v4/entries/{queue}/{tier}/{division}
     * @param queue queue
     * @param tier tier
     * @param division division
     * @queryParam page, default: 1
     * @return Set of League Entry Dto
     */
    public Set<LeagueEntryDto> getLeagueEntries(String queue, String tier, String division, int page) {
        return null;
    }

    public Set<LeagueEntryDto> getLeagueEntries(String queue, String tier, String division) {
        return getLeagueEntries(queue, tier, division, 1) ;
    }

    /**
     * call /lol/league/v4/challengerleagues/by-queue/{queue}
     * @param queue queue
     * @return League List Dto
     */
    public LeagueListDto getChallengerLeaguesByQueue(String queue) {
        return null;
    }

    /**
     * call /lol/league/v4/grandmasterleagues/by-queue/{queue}
     * @param queue queue
     * @return League List Dto
     */
    public LeagueListDto getGrandMasterLeaguesByQueue(String queue) {
        return null;
    }

    /**
     * call /lol/league/v4/masterleagues/by-queue/{queue}
     * @param queue queue
     * @return League List Dto
     */
    public LeagueListDto getMasterLeaguesByQueue(String queue) {
        return null;
    }

// MATCH

    /**
     * call /lol/match/v5/matches/by-puuid/{puuid}/ids
     * @param puuid puuid
     * @queryParam startTime, endTime, queue, type, start, count
     * @return List of String
     */
    public List<String> getMatchIdsByPuuid(String puuid) {
        return null;
    }

    /**
     * call /lol/match/v5/matches/{matchId}
     * @param matchId match's id
     * @return Match Dto
     */
    public MatchDto getMatchByMatchId(String matchId) {
        return null;
    }

    /**
     * call /lol/match/v5/matches/{matchId}/timeline
     * @param matchId match's id
     * @return Match Timeline Dto
     */
    public MatchTimelineDto getMatchTimelineByMatchId(String matchId) {
        return null;
    }

// SUMMONER

    /**
     * /fulfillment/v1/summoners/by-puuid/{rsoPUUID}
     * @param rsoPUUID rso encrypted puuid
     * @return Summoner Dto
     */
    public SummonerDto getSummonerByRsoPuuid(String rsoPUUID) {
        return null;
    }

    /**
     * /lol/summoner/v4/summoners/by-account/{encryptedAccountId}
     * @param encryptedAccountId encrypted account id
     * @return Summoner Dto
     */
    public SummonerDto getSummonerByAccountId(String encryptedAccountId) {
        return null;
    }

    /**
     * /lol/summoner/v4/summoners/by-name/{summonerName}
     * @param summonerName summoner name
     * @return Summoner Dto
     */
    public SummonerDto getSummonerBySummonerName(String summonerName) {
        return null;
    }

    /**
     * /lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}
     * @param encryptedPUUID encrypted puuid
     * @return Summoner Dto
     */
    public SummonerDto getSummonerByPuuid(String encryptedPUUID) {
        return null;
    }

    /**
     * /lol/summoner/v4/summoners/me
     * @param Authorization authorization bearer token
     * @return Summoner Dto
     */
    public SummonerDto getSummonerByAccessToken(String Authorization) {
        return null;
    }

    /**
     * /lol/summoner/v4/summoners/{encryptedSummonerId}
     * @param encryptedSummonerId encrypted summoner id
     * @return Summoner Dto
     */
    public SummonerDto getSummonerBySummonerId(String encryptedSummonerId) {
        return null;
    }
}
