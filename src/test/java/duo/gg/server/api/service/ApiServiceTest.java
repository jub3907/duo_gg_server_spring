package duo.gg.server.api.service;

import duo.gg.server.api.dto.account.AccountDto;
import duo.gg.server.api.dto.summoner.SummonerDto;
import duo.gg.server.api.repository.ApiRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


//! Warning: API 호출 횟수 제한이 걸려있기 때문에, 전체 실행 x.
@SpringBootTest
class ApiServiceTest {

    @Autowired
    ApiService apiService;

    private final String name = "21세기광부";
    private final String puuid = "WhX0_L0SzY-UpxFTZFvHASktCbDc-loiJln6RnMNU5Ptwj_6lw98sE-iOPamqp_GNs71T37LFIndLg";
    private final String summonerId = "JlGUV6boigRMNJTG25zAzGRjFMbwnl6XDKbbzqrShuH1Jw";
    private final String accountId = "274o8M0Xs6IGliyTC6k6t6DgKL3JZ6azB9hrR9eNECdL";
    private final String tagLine = "KR1";

    @Test
    void getAccountByPuuid() {
        AccountDto accountDto = apiService.getAccountByPuuid(puuid);
        assertThat(accountDto.getGameName()).isEqualTo(name);
    }

    @Test
    void getAccountByRiotId() {
        AccountDto accountDto = apiService.getAccountByRiotId(name, tagLine);
        assertThat(accountDto.getPuuid()).isEqualTo(puuid);

    }

    @Test
    void getAccountByAccessToken() {
        // no access token
    }

    @Test
    void getChampionMasteriesByPuuid() {
    }

    @Test
    void getChampionMasteryByPuuidAndChampionId() {
    }

    @Test
    void getChampionMasteriesByPuuidDescending() {
    }

    @Test
    void testGetChampionMasteriesByPuuidDescending() {
    }

    @Test
    void getChampionMasteriesBySummonerId() {
    }

    @Test
    void getChampionMasteryBySummonerIdAndChampionId() {
    }

    @Test
    void getChampionMasteriesBySummonerIdDescending() {
    }

    @Test
    void testGetChampionMasteriesBySummonerIdDescending() {
    }

    @Test
    void getChampionMasteryScoresByPuuid() {
    }

    @Test
    void getChampionMasteryScoresBySummonerId() {
    }

    @Test
    void getChampionRotation() {
    }

    @Test
    void getLeagueEntriesExp() {
    }

    @Test
    void getLeaguesByLeagueId() {
    }

    @Test
    void getLeagueEntriesBySummonerId() {
    }

    @Test
    void getLeagueEntries() {
    }

    @Test
    void testGetLeagueEntries() {
    }

    @Test
    void getChallengerLeaguesByQueue() {
    }

    @Test
    void getGrandMasterLeaguesByQueue() {
    }

    @Test
    void getMasterLeaguesByQueue() {
    }

    @Test
    void getMatchIdsByPuuid() {
    }

    @Test
    void getMatchByMatchId() {
    }

    @Test
    void getMatchTimelineByMatchId() {
    }

    @Test
    void getSummonerByRsoPuuid() {
    }

    @Test
    void getSummonerByAccountId() {
    }

    @Test
    public void getSummonerBySummonerName() {
        SummonerDto summonerDto = apiService.getSummonerBySummonerName(name);

        assertThat(summonerDto.getPuuid()).isEqualTo(puuid);
    }

    @Test
    void getSummonerByPuuid() {
    }

    @Test
    void getSummonerByAccessToken() {
    }

    @Test
    void getSummonerBySummonerId() {
    }



}