package duo.gg.server.api.service;

import duo.gg.server.api.constant.DivisionEnum;
import duo.gg.server.api.constant.QueueEnum;
import duo.gg.server.api.constant.TierEnum;
import duo.gg.server.api.dto.account.AccountDto;
import duo.gg.server.api.dto.champion.ChampionInfoDto;
import duo.gg.server.api.dto.championMastery.ChampionMasteryDto;
import duo.gg.server.api.dto.league.LeagueEntryDto;
import duo.gg.server.api.dto.league.LeagueListDto;
import duo.gg.server.api.dto.match.MatchDto;
import duo.gg.server.api.dto.summoner.SummonerDto;
import duo.gg.server.api.repository.ApiRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
        // TODO: Access Token을 사용한 테스트 추가
    }

    @Test
    void getChampionMasteriesByPuuid() {
        List<ChampionMasteryDto> dtos = apiService.getChampionMasteriesByPuuid(puuid);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    void getChampionMasteryByPuuidAndChampionId() {
        ChampionMasteryDto dto = apiService.getChampionMasteryByPuuidAndChampionId(puuid, championId);
        assertThat(dto.getChampionId()).isEqualTo(championId);

    }

    @Test
    void getChampionMasteriesByPuuidDescending() {
        List<ChampionMasteryDto> dtos = apiService.getChampionMasteriesByPuuidDescending(puuid, 2);
        assertThat(dtos.size()).isEqualTo(2);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);

        List<ChampionMasteryDto> dtos2 = apiService.getChampionMasteriesByPuuidDescending(puuid);
        assertThat(dtos2.size()).isEqualTo(3);
    }

    @Test
    void getChampionMasteriesBySummonerId() {
        List<ChampionMasteryDto> dtos = apiService.getChampionMasteriesBySummonerId(summonerId);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    void getChampionMasteryBySummonerIdAndChampionId() {
        ChampionMasteryDto dto = apiService.getChampionMasteryBySummonerIdAndChampionId(summonerId, championId);
        assertThat(dto.getChampionId()).isEqualTo(championId);
    }

    @Test
    void getChampionMasteriesBySummonerIdDescending() {
        List<ChampionMasteryDto> dtos = apiService.getChampionMasteriesBySummonerIdDescending(summonerId, 2);
        List<ChampionMasteryDto> dtos2 = apiService.getChampionMasteriesBySummonerIdDescending(summonerId);

        assertThat(dtos.size()).isEqualTo(2);
        assertThat(dtos2.size()).isEqualTo(3);
        assertThat(dtos.get(0).getChampionId()).isEqualTo(championId);
    }

    @Test
    void getChampionMasteryScoresByPuuid() {
        Integer score = apiService.getChampionMasteryScoresByPuuid(puuid);
        assertThat(score).isInstanceOf(Integer.class);
    }

    @Test
    void getChampionMasteryScoresBySummonerId() {
        Integer score = apiService.getChampionMasteryScoresBySummonerId(summonerId);
        assertThat(score).isInstanceOf(Integer.class);
    }

    @Test
    void getChampionRotation() {
        ChampionInfoDto dto = apiService.getChampionRotation();
        assertThat(dto.getFreeChampionIds().size()).isEqualTo(20);
    }

    @Test
    void getLeagueEntriesExp() {
        apiService.getLeagueEntriesExp(QueueEnum.RANKED_SOLO_5x5, TierEnum.CHALLENGER, DivisionEnum.I);
        // TODO: 테스트 추가
    }

    @Test
    void getLeaguesByLeagueId() {
        LeagueListDto dto = apiService.getLeaguesByLeagueId(leagueId);
        assertThat(dto.getTier()).isEqualTo(leagueTier);

    }

    @Test
    void getLeagueEntriesBySummonerId() {
        List<LeagueEntryDto> dtos = apiService.getLeagueEntriesBySummonerId(summonerId);
        // TODO: 테스트 추가
    }

    @Test
    void getLeagueEntries() {
        List<LeagueEntryDto> dtos = apiService.getLeagueEntries(QueueEnum.RANKED_SOLO_5x5, TierEnum.DIAMOND, DivisionEnum.I);
        // TODO: 테스트 추가
    }

    @Test
    void getChallengerLeaguesByQueue() {
        LeagueListDto dto = apiService.getChallengerLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
        assertThat(dto.getTier()).isEqualTo(TierEnum.CHALLENGER.name());
    }

    @Test
    void getGrandMasterLeaguesByQueue() {
        LeagueListDto dto = apiService.getGrandMasterLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
        assertThat(dto.getTier()).isEqualTo(TierEnum.GRANDMASTER.name());
    }

    @Test
    void getMasterLeaguesByQueue() {
        LeagueListDto dto = apiService.getMasterLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
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
        MatchDto dto = apiService.getMatchByMatchId(matchId);
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
        SummonerDto dto = apiService.getSummonerByAccountId(accountId);
        assertThat(dto.getName()).isEqualTo(name);
    }

    @Test
    public void getSummonerBySummonerName() {
        SummonerDto summonerDto = apiService.getSummonerBySummonerName(name);

        assertThat(summonerDto.getPuuid()).isEqualTo(puuid);
    }

    @Test
    void getSummonerByPuuid() {
        SummonerDto dto = apiService.getSummonerByPuuid(puuid);
        assertThat(dto.getName()).isEqualTo(name);
    }

    @Test
    void getSummonerByAccessToken() {
        // TODO: Access Token을 사용한 테스트 추가
    }

    @Test
    void getSummonerBySummonerId() {
        SummonerDto dto = apiService.getSummonerBySummonerId(summonerId);
        assertThat(dto.getName()).isEqualTo(name);
    }



}