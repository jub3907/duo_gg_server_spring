package duo.gg.server.api.service;

import duo.gg.server.constant.DivisionEnum;
import duo.gg.server.constant.QueueEnum;
import duo.gg.server.constant.TierEnum;
import duo.gg.server.api.dto.account.AccountApiResult;
import duo.gg.server.api.dto.champion.ChampionInfoApiResult;
import duo.gg.server.api.dto.mastery.MasteryApiResult;
import duo.gg.server.api.dto.league.LeagueEntryApiResult;
import duo.gg.server.api.dto.league.LeagueListApiResult;
import duo.gg.server.api.dto.match.MatchApiResult;
import duo.gg.server.api.dto.match.MatchTimelineApiResult;
import duo.gg.server.api.dto.summoner.SummonerApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;


import java.time.Duration;
import java.util.*;


@Service
@Slf4j
public class ApiService {

    @Value("${riot.api-key}")
    private String apiKey;

    private WebClient getWebClient(String baseUrl) {
        return getWebClient(baseUrl, null);
    }

    private ExchangeStrategies getExchangeStrategies() {
        return ExchangeStrategies.builder()
                .codecs(codecConfigure ->
                        codecConfigure
                        .defaultCodecs()
                        .maxInMemorySize(10 * 1024 * 1024))
                .build();
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
                .exchangeStrategies(getExchangeStrategies())
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

    private <T> List<T> apiCallAsDtoList(WebClient webClient, String uri, Class<T[]> className) {
        T[] block = webClient.get()
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

        return Arrays.asList(block);
    }

// ACCOUNT
// baseUrl : https://asia.api.riotgames.com

    /**
     * call https://asia.api.riotgames.com/riot/account/v1/accounts/by-puuid/{puuid}
     * @param puuid puuid
     * @return AccountDto
     */
    public AccountApiResult getAccountByPuuid(String puuid) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com");
        String uri = "/riot/account/v1/accounts/by-puuid/" + puuid;

        return apiCall(webClient, uri, AccountApiResult.class);
    }

    /**
     * call /riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}
     * When querying for a player by their riot id, the gameName and tagLine query params are required.
     * However not all accounts have a gameName and tagLine associated so these fields may not be included in the response.
     * @param tagLine tagLine
     * @param gameName gameName
     * @return AccountDto
     */
    public AccountApiResult getAccountByRiotId(String gameName, String tagLine) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com");
        String uri = "/riot/account/v1/accounts/by-riot-id/" + gameName + "/" + tagLine;

        return apiCall(webClient, uri, AccountApiResult.class);
    }

    /**
     * call /riot/account/v1/accounts/me
     * @param Authorization AccessToken
     * @return AccountDto
     */
    public AccountApiResult getAccountByAccessToken(String Authorization) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com", Authorization);
        String uri = "/riot/account/v1/accounts/me";

        return apiCall(webClient, uri, AccountApiResult.class);
    }


// CHAMPION-MASTERY
// baseUrl : https://kr.api.riotgames.com

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}
     * @param encryptedPUUID encryptedPUUID
     * @return List<MasteryDto>
     */
    public List<MasteryApiResult> getMasteriesByPuuid(String encryptedPUUID) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/champion-masteries/by-puuid/" + encryptedPUUID;

        return apiCallAsDtoList(webClient, uri, MasteryApiResult[].class);
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/by-champion/{championId}
     * @param encryptedPUUID encryptedPUUID
     * @param championId championId
     * @return MasteryDto
     */
    public MasteryApiResult getMasteryByPuuidAndChampionId(String encryptedPUUID, Long championId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/champion-masteries/by-puuid/" + encryptedPUUID +"/by-champion/" + championId;

        return apiCall(webClient, uri, MasteryApiResult.class);
    }

    /**
     * /lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/top
     * @param encryptedPUUID encryptedPUUID
     * @param count default 3
     * @return List<MasteryDto>
     */
    public List<MasteryApiResult> getMasteriesByPuuidDescending(String encryptedPUUID, int count) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/champion-masteries/by-puuid/" + encryptedPUUID + "/top/?count=" + count;

        return apiCallAsDtoList(webClient, uri, MasteryApiResult[].class);
    }

    public List<MasteryApiResult> getMasteriesByPuuidDescending(String encryptedPUUID) {
        return getMasteriesByPuuidDescending(encryptedPUUID, 3);
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}
     * @param encryptedSummonerId encryptedSummonerId
     * @return List<MasteryDto>
     */
    public List<MasteryApiResult> getMasteriesBySummonerId(String encryptedSummonerId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/champion-masteries/by-summoner/" + encryptedSummonerId;

        return apiCallAsDtoList(webClient, uri, MasteryApiResult[].class);
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}
     * @param encryptedSummonerId encrypted summoner id
     * @param championId champion's id
     * @return Champion Mastery Dto
     */
    public MasteryApiResult getMasteryBySummonerIdAndChampionId(String encryptedSummonerId, Long championId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/champion-masteries/by-summoner/" + encryptedSummonerId + "/by-champion/" + championId;

        return apiCall(webClient, uri, MasteryApiResult.class);
    }

    /**
     * call /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/top
     * @param encryptedSummonerId encrypted summoner id
     * @param count default 3
     * @return List of Champion Mastery Dto
     */
    public List<MasteryApiResult> getMasteriesBySummonerIdDescending(String encryptedSummonerId, int count) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/champion-masteries/by-summoner/" + encryptedSummonerId + "/top?count=" + count;

        return apiCallAsDtoList(webClient, uri, MasteryApiResult[].class);
    }

    public List<MasteryApiResult> getMasteriesBySummonerIdDescending(String encryptedSummonerId) {
        return getMasteriesBySummonerIdDescending(encryptedSummonerId, 3);
    }

    /**
     * call /lol/champion-mastery/v4/scores/by-puuid/{encryptedPUUID}
     * @param encryptedPUUID encrypted puuid
     * @return Integer
     */
    public Integer getMasteryScoresByPuuid(String encryptedPUUID) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/scores/by-puuid/" + encryptedPUUID;

        return apiCall(webClient, uri, Integer.class);
    }

    /**
     * call /lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}
     * @param encryptedSummonerId encrypted summoner id
     * @return Integer
     */
    public Integer getMasteryScoresBySummonerId(String encryptedSummonerId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/champion-mastery/v4/scores/by-summoner/" + encryptedSummonerId;

        return apiCall(webClient, uri, Integer.class);
    }

// CHAMPION
// baseUrl : https://kr.api.riotgames.com

    /**
     * call /lol/platform/v3/champion-rotations
     * @return Champion Info Dto
     */
    public ChampionInfoApiResult getChampionRotation() {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/platform/v3/champion-rotations";

        return apiCall(webClient, uri, ChampionInfoApiResult.class);
    }

// LEAGUE-EXP
// baseUrl : https://kr.api.riotgames.com

    /**
     * call /lol/league-exp/v4/entries/{queue}/{tier}/{division}
     * @param queue queue
     * @param tier tier
     * @param division division
     * @return List of League Entry Dto
     */
    public List<LeagueEntryApiResult> getLeagueEntriesExp(QueueEnum queue, TierEnum tier, DivisionEnum division, int page) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/league-exp/v4/entries/" + queue + "/" + tier + "/" + division + "?page=" + page;

        return apiCallAsDtoList(webClient, uri, LeagueEntryApiResult[].class);
    }

    public List<LeagueEntryApiResult> getLeagueEntriesExp(QueueEnum queue, TierEnum tier, DivisionEnum division) {
        return getLeagueEntriesExp(queue, tier, division, 1);
    }

// LEAGUE
// baseUrl : https://kr.api.riotgames.com

    /**
     * call /lol/league/v4/leagues/{leagueId}
     * @param leagueId league's id value
     * @return League List Dto
     */
    public LeagueListApiResult getLeaguesByLeagueId(String leagueId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/league/v4/leagues/" + leagueId;

        return apiCall(webClient, uri, LeagueListApiResult.class);
    }

    /**
     * call /lol/league/v4/entries/by-summoner/{encryptedSummonerId}
     * @param encryptedSummonerId encrypted summoner id
     * @return List of League Entry Dto
     */
    public List<LeagueEntryApiResult> getLeagueEntriesBySummonerId(String encryptedSummonerId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/league/v4/entries/by-summoner/" + encryptedSummonerId;

        return apiCallAsDtoList(webClient, uri, LeagueEntryApiResult[].class);
    }

    /**
     * call /lol/league/v4/entries/{queue}/{tier}/{division}
     *
     * @param queue    queue
     * @param tier     tier
     * @param division division
     * @return Set of League Entry Dto
     * @queryParam page, default: 1
     */
    public List<LeagueEntryApiResult> getLeagueEntries(QueueEnum queue, TierEnum tier, DivisionEnum division, int page) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/league/v4/entries/" + queue + "/" + tier + "/" + division + "?page=" + page;

        return apiCallAsDtoList(webClient, uri, LeagueEntryApiResult[].class);
    }

    public List<LeagueEntryApiResult> getLeagueEntries(QueueEnum queue, TierEnum tier, DivisionEnum division) {
        return getLeagueEntries(queue, tier, division, 1) ;
    }

    /**
     * call /lol/league/v4/challengerleagues/by-queue/{queue}
     * @param queue queue
     * @return League List Dto
     */
    public LeagueListApiResult getChallengerLeaguesByQueue(QueueEnum queue) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/league/v4/challengerleagues/by-queue/" + queue;

        return apiCall(webClient, uri, LeagueListApiResult.class);
    }

    /**
     * call /lol/league/v4/grandmasterleagues/by-queue/{queue}
     * @param queue queue
     * @return League List Dto
     */
    public LeagueListApiResult getGrandMasterLeaguesByQueue(QueueEnum queue) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/league/v4/grandmasterleagues/by-queue/" + queue;

        return apiCall(webClient, uri, LeagueListApiResult.class);
    }

    /**
     * call /lol/league/v4/masterleagues/by-queue/{queue}
     * @param queue queue
     * @return League List Dto
     */
    public LeagueListApiResult getMasterLeaguesByQueue(QueueEnum queue) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/league/v4/masterleagues/by-queue/" + queue;

        System.out.println("uri = " + uri);

        return apiCall(webClient, uri, LeagueListApiResult.class);
    }

// MATCH
// baseUrl : https://asia.api.riotgames.com

    /**
     * /lol/match/v5/matches/by-puuid/{puuid}/ids
     *
     * @param puuid puuid
     * @return List of String
     * @queryParam startTime, endTime, queue, type, start, count
     */
    public List<String> getMatchIdsByPuuid(String puuid, Integer start, Integer count,
                                           Long startTime, Long endTime, Integer queue, String type) {

        WebClient webClient = getWebClient("https://asia.api.riotgames.com");

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/lol/match/v5/matches/by-puuid/" + puuid + "/ids")
                .queryParamIfPresent("start", Optional.ofNullable(start))
                .queryParamIfPresent("count", Optional.ofNullable(count))
                .queryParamIfPresent("startTime", Optional.ofNullable(startTime))
                .queryParamIfPresent("endTime", Optional.ofNullable(endTime))
                .queryParamIfPresent("queue", Optional.ofNullable(queue))
                .queryParamIfPresent("type", Optional.ofNullable(type))
                .build(true);

        System.out.println("uriComponents.toString() = " + uriComponents.toString());

        return apiCallAsDtoList(webClient, uriComponents.toString(), String[].class);
    }

    public List<String> getMatchIdsByPuuid(String puuid, Integer start, Integer count) {
        return getMatchIdsByPuuid(puuid, start, count, null, null, null, null);
    }

    /**
     * /lol/match/v5/matches/{matchId}
     * @param matchId match's id
     * @return Match Dto
    */
    public MatchApiResult getMatchByMatchId(String matchId) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com");
        String uri = "/lol/match/v5/matches/" + matchId;

        return apiCall(webClient, uri, MatchApiResult.class);
    }

    /**
     * /lol/match/v5/matches/{matchId}/timeline
     * @param matchId match's id
     * @return Match Timeline Dto
     */
    public MatchTimelineApiResult getMatchTimelineByMatchId(String matchId) {
        WebClient webClient = getWebClient("https://asia.api.riotgames.com");
        return null;
        //TODO: TimeLine 기능 구현
    }

// SUMMONER
// baseUrl : https://kr.api.riotgames.com

    /**
     * /fulfillment/v1/summoners/by-puuid/{rsoPUUID}
     * @param rsoPUUID rso encrypted puuid
     * @return Summoner Dto
     */
    public SummonerApiResult getSummonerByRsoPuuid(String rsoPUUID) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/fulfillment/v1/summoners/by-puuid/" + rsoPUUID;

        return apiCall(webClient, uri, SummonerApiResult.class);
    }

    /**
     * /lol/summoner/v4/summoners/by-account/{encryptedAccountId}
     * @param encryptedAccountId encrypted account id
     * @return Summoner Dto
     */
    public SummonerApiResult getSummonerByAccountId(String encryptedAccountId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/summoner/v4/summoners/by-account/" + encryptedAccountId;

        return apiCall(webClient, uri, SummonerApiResult.class);
    }

    /**
     * /lol/summoner/v4/summoners/by-name/{summonerName}
     * @param summonerName summoner name
     * @return Summoner Dto
     */
    public SummonerApiResult getSummonerBySummonerName(String summonerName) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/summoner/v4/summoners/by-name/" + summonerName;

        return apiCall(webClient, uri, SummonerApiResult.class);
    }

    /**
     * /lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}
     * @param encryptedPUUID encrypted puuid
     * @return Summoner Dto
     */
    public SummonerApiResult getSummonerByPuuid(String encryptedPUUID) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/summoner/v4/summoners/by-puuid/" + encryptedPUUID;

        return apiCall(webClient, uri, SummonerApiResult.class);
    }

    /**
     * /lol/summoner/v4/summoners/me
     * @param Authorization authorization bearer token
     * @return Summoner Dto
     */
    public SummonerApiResult getSummonerByAccessToken(String Authorization) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com", Authorization);
        String uri = "/lol/summoner/v4/summoners/me";

        return apiCall(webClient, uri, SummonerApiResult.class);
    }

    /**
     * /lol/summoner/v4/summoners/{encryptedSummonerId}
     * @param encryptedSummonerId encrypted summoner id
     * @return Summoner Dto
     */
    public SummonerApiResult getSummonerBySummonerId(String encryptedSummonerId) {
        WebClient webClient = getWebClient("https://kr.api.riotgames.com");
        String uri = "/lol/summoner/v4/summoners/" + encryptedSummonerId;

        return apiCall(webClient, uri, SummonerApiResult.class);
    }
}
