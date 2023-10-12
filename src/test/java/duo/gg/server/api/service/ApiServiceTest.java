package duo.gg.server.api.service;

import duo.gg.server.api.constant.DivisionEnum;
import duo.gg.server.api.constant.QueueEnum;
import duo.gg.server.api.constant.TierEnum;
import duo.gg.server.api.dto.account.AccountApiResult;
import duo.gg.server.api.dto.champion.ChampionInfoApiResult;
import duo.gg.server.api.dto.mastery.MasteryApiResult;
import duo.gg.server.api.dto.league.LeagueEntryApiResult;
import duo.gg.server.api.dto.league.LeagueListApiResult;
import duo.gg.server.api.dto.match.MatchApiResult;
import duo.gg.server.api.dto.summoner.SummonerApiResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


//! Warning: API 호출 횟수 제한이 걸려있기 때문에, 전체 실행 x.
@SpringBootTest
@Slf4j
class ApiServiceTest {

    @Autowired
    ApiService apiService;

    private final String name = "21세기광부";
    private final String puuid = "WhX0_L0SzY-UpxFTZFvHASktCbDc-loiJln6RnMNU5Ptwj_6lw98sE-iOPamqp_GNs71T37LFIndLg";
    private final String summonerId = "JlGUV6boigRMNJTG25zAzGRjFMbwnl6XDKbbzqrShuH1Jw";
    private final String accountId = "274o8M0Xs6IGliyTC6k6t6DgKL3JZ6azB9hrR9eNECdL";
    private final String tagLine = "KR1";

    private final Long championId = 412L;
    private final String championName = "Thresh";

    private final String leagueId = "966df365-7dea-34ca-839a-2cec050ba64a";
    private final String leagueTier = TierEnum.CHALLENGER.name();

    private final String matchId = "KR_6730690706";

    @Test
    void getAccountByPuuid() {
        AccountApiResult accountApiResult = apiService.getAccountByPuuid(puuid);
        assertThat(accountApiResult.getGameName()).isEqualTo(name);
    }

    @Test
    void getAccountByRiotId() {
        AccountApiResult accountApiResult = apiService.getAccountByRiotId(name, tagLine);
        assertThat(accountApiResult.getPuuid()).isEqualTo(puuid);

    }

    @Test
    void getAccountByAccessToken() {
        // TODO: Access Token을 사용한 테스트 추가
    }

    @Test
    void getMasteriesByPuuid() {
        List<MasteryApiResult> dtos = apiService.getMasteriesByPuuid(puuid);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    void getMasteryByPuuidAndChampionId() {
        MasteryApiResult dto = apiService.getMasteryByPuuidAndChampionId(puuid, championId);
        assertThat(dto.getChampionId()).isEqualTo(championId);

    }

    @Test
    void getMasteriesByPuuidDescending() {
        List<MasteryApiResult> dtos = apiService.getMasteriesByPuuidDescending(puuid, 2);
        assertThat(dtos.size()).isEqualTo(2);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);

        List<MasteryApiResult> dtos2 = apiService.getMasteriesByPuuidDescending(puuid);
        assertThat(dtos2.size()).isEqualTo(3);
    }

    @Test
    void getMasteriesBySummonerId() {
        List<MasteryApiResult> dtos = apiService.getMasteriesBySummonerId(summonerId);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    void getMasteryBySummonerIdAndChampionId() {
        MasteryApiResult dto = apiService.getMasteryBySummonerIdAndChampionId(summonerId, championId);
        assertThat(dto.getChampionId()).isEqualTo(championId);
    }

    @Test
    void getMasteriesBySummonerIdDescending() {
        List<MasteryApiResult> dtos = apiService.getMasteriesBySummonerIdDescending(summonerId, 2);
        List<MasteryApiResult> dtos2 = apiService.getMasteriesBySummonerIdDescending(summonerId);

        assertThat(dtos.size()).isEqualTo(2);
        assertThat(dtos2.size()).isEqualTo(3);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    void getMasteryScoresByPuuid() {
        Integer score = apiService.getMasteryScoresByPuuid(puuid);
        assertThat(score).isInstanceOf(Integer.class);
    }

    @Test
    void getMasteryScoresBySummonerId() {
        Integer score = apiService.getMasteryScoresBySummonerId(summonerId);
        assertThat(score).isInstanceOf(Integer.class);
    }

    @Test
    void getChampionRotation() {
        ChampionInfoApiResult dto = apiService.getChampionRotation();
        assertThat(dto.getFreeChampionIds().size()).isEqualTo(20);
    }

    @Test
    void getLeagueEntriesExp() {
        apiService.getLeagueEntriesExp(QueueEnum.RANKED_SOLO_5x5, TierEnum.CHALLENGER, DivisionEnum.I);
        // TODO: 테스트 추가
    }

    @Test
    void getLeaguesByLeagueId() {
        LeagueListApiResult dto = apiService.getLeaguesByLeagueId(leagueId);
        assertThat(dto.getTier()).isEqualTo(leagueTier);

    }

    @Test
    void getLeagueEntriesBySummonerId() {
        List<LeagueEntryApiResult> dtos = apiService.getLeagueEntriesBySummonerId(summonerId);
        // TODO: 테스트 추가
    }

    @Test
    void getLeagueEntries() {
        List<LeagueEntryApiResult> dtos = apiService.getLeagueEntries(QueueEnum.RANKED_SOLO_5x5, TierEnum.DIAMOND, DivisionEnum.I);
        // TODO: 테스트 추가
    }

    @Test
    void getChallengerLeaguesByQueue() {
        LeagueListApiResult dto = apiService.getChallengerLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
        assertThat(dto.getTier()).isEqualTo(TierEnum.CHALLENGER.name());
    }

    @Test
    void getGrandMasterLeaguesByQueue() {
        LeagueListApiResult dto = apiService.getGrandMasterLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
        assertThat(dto.getTier()).isEqualTo(TierEnum.GRANDMASTER.name());
    }

    @Test
    void getMasterLeaguesByQueue() {
        LeagueListApiResult dto = apiService.getMasterLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
        assertThat(dto.getTier()).isEqualTo(TierEnum.MASTER.name());
    }

    @Test
    void getMatchIdsByPuuid() {
        List<String> ids = apiService.getMatchIdsByPuuid(puuid, 0, 20, null, null, null, null);
        List<String> ids2 = apiService.getMatchIdsByPuuid(puuid, 0, 20);
        assertThat(ids.size()).isEqualTo(20);
        assertThat(ids2.size()).isEqualTo(20);
    }

    @Test
    void getMatchByMatchId() {
        MatchApiResult dto = apiService.getMatchByMatchId(matchId);
        assertThat(dto.getMetadata().getMatchId()).isEqualTo(matchId);
    }

    @Test
    void getMatchTimelineByMatchId() {
        // TODO: TimeLine 테스트 구현
    }

    @Test
    void getSummonerByRsoPuuid() {
        // TODO: RsoPuuid를 사용한 테스트 구현
    }

    @Test
    void getSummonerByAccountId() {
        SummonerApiResult dto = apiService.getSummonerByAccountId(accountId);
        assertThat(dto.getName()).isEqualTo(name);
    }

    @Test
    public void getSummonerBySummonerName() {
        SummonerApiResult summonerApiResult = apiService.getSummonerBySummonerName(name);

        assertThat(summonerApiResult.getPuuid()).isEqualTo(puuid);
    }

    @Test
    void getSummonerByPuuid() {
        SummonerApiResult dto = apiService.getSummonerByPuuid(puuid);
        assertThat(dto.getName()).isEqualTo(name);
    }

    @Test
    void getSummonerByAccessToken() {
        // TODO: Access Token을 사용한 테스트 추가
    }

    @Test
    void getSummonerBySummonerId() {
        SummonerApiResult dto = apiService.getSummonerBySummonerId(summonerId);
        assertThat(dto.getName()).isEqualTo(name);
    }



}