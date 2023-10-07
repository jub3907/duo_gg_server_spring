package duo.gg.server.api.service;

import duo.gg.server.api.dto.account.AccountDto;
import duo.gg.server.api.dto.champion.ChampionInfoDto;
import duo.gg.server.api.dto.championMastery.ChampionMasteryDto;
import duo.gg.server.api.dto.league.LeagueEntryDto;
import duo.gg.server.api.dto.league.LeagueListDto;
import duo.gg.server.api.dto.match.MatchDto;
import duo.gg.server.api.dto.match.MatchTimelineDto;
import duo.gg.server.api.dto.summoner.SummonerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;


import java.time.Duration;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ApiService {

    @Value("${riot.api-key}")
    private String apiKey;

    private WebClient getWebClient(String baseUrl) {
        return getWebClient(baseUrl, null);
    }

    private WebClient getWebClient(String baseUrl, String token) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeaders(
                        httpHeaders -> {
                            httpHeaders.add("Accept-Language", "ko,en-US;q=0.9,en;q=0.8,ko-KR;q=0.7,vi;q=0.6");
                            httpHeaders.add("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
                            httpHeaders.add("Origin", "https://developer.riotgames.com");
                            httpHeaders.add("X-Riot-Token", apiKey);
                            if (token != null) {
                                httpHeaders.add("Authorization", token);
                            }
                        }
                )
                .build();
    }


    private <T> T apiCall(WebClient webClient, String uri, Class<T> className) {
        return webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(className);
                    } else {
                        return response.createException().flatMap(Mono::error);
                    }
                })
                .retryWhen(Retry.fixedDelay(1, Duration.ofSeconds(2)))
                .block();
    }

// ACCOUNT
// baseUrl : https://asia.api.riotgames.com

    /**
     *
     * call https://asia.api.riotgames.com/riot/account/v1/accounts/by-puuid/{puuid}
     * @param puuid puuid
     * @return AccountDto
     */
    public AccountDto getAccountByPuuid(String puuid) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com");
        String uri = "/riot/account/v1/accounts/by-puuid/" + puuid;

        return apiCall(webClient, uri, AccountDto.class);
    }

    /**
     * call /riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}
     * When querying for a player by their riot id, the gameName and tagLine query params are required.
     * However not all accounts have a gameName and tagLine associated so these fields may not be included in the response.
     * @param tagLine tagLine
     * @param gameName gameName
     * @return AccountDto
     */
    public AccountDto getAccountByRiotId(String gameName, String tagLine) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com");
        String uri = "/riot/account/v1/accounts/by-riot-id/" + gameName + "/" + tagLine;

        return apiCall(webClient, uri, AccountDto.class);
    }

    /**
     * call /riot/account/v1/accounts/me
     * @param Authorization AccessToken
     * @return AccountDto
     */
    public AccountDto getAccountByAccessToken(String Authorization) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com", Authorization);
        String uri = "/riot/account/v1/accounts/me";

        return apiCall(webClient, uri, AccountDto.class);
    }


// CHAMPION-MASTERY
// baseUrl : https://kr.api.riotgames.com

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
// baseUrl : https://kr.api.riotgames.com

    /**
     * call /lol/platform/v3/champion-rotations
     * @return Champion Info Dto
     */
    public ChampionInfoDto getChampionRotation() {
        return null;
    }

// LEAGUE-EXP
// baseUrl : https://kr.api.riotgames.com

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
// baseUrl : https://kr.api.riotgames.com

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
// baseUrl : https://asia.api.riotgames.com

    /**
     * /lol/match/v5/matches/by-puuid/{puuid}/ids
     * @param puuid puuid
     * @queryParam startTime, endTime, queue, type, start, count
     * @return List of String
     */
    public List<String> getMatchIdsByPuuid(String puuid) {
        return null;
    }

    /**
     * /lol/match/v5/matches/{matchId}
     * @param matchId match's id
     * @return Match Dto
     */
    public MatchDto getMatchByMatchId(String matchId) {
        return null;
    }

    /**
     * /lol/match/v5/matches/{matchId}/timeline
     * @param matchId match's id
     * @return Match Timeline Dto
     */
    public MatchTimelineDto getMatchTimelineByMatchId(String matchId) {
        return null;
    }

// SUMMONER
// baseUrl : https://kr.api.riotgames.com

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
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/summoner/v4/summoners/by-name/" + summonerName;

        return apiCall(webClient, uri, SummonerDto.class);
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
