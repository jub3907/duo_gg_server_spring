package duo.gg.server.league;

import duo.gg.server.api.dto.league.LeagueEntryApiResult;
import duo.gg.server.api.dto.league.LeagueItemApiResult;
import duo.gg.server.constant.QueueEnum;
import duo.gg.server.league.dto.RankingDto;
import duo.gg.server.league.entry.League;
import duo.gg.server.summoner.entity.Summoner;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LeagueRepository {

    private final EntityManager em;

    public Optional<League> findBySummonerIdAndQueueType(String summonerId, QueueEnum queueType) {
        return em.createQuery("select l from League l where l.summonerId = :summonerId and l.queueType = :queueType", League.class)
                .setParameter("summonerId", summonerId)
                .setParameter("queueType", queueType)
                .getResultList()
                .stream().findAny();
    }

    public List<League> findBySummonerId(String summonerId) {
        return em.createQuery("select l from League l where l.summonerId = :summonerId", League.class)
                .setParameter("summonerId", summonerId)
                .getResultList();
    }


    public List<RankingDto> findRanking(Integer offset, Integer limit) {
        List resultList = em.createQuery(
                        "select l, s " +
                                "from League l left join Summoner s on l.summonerName = s.name " +
                                "order by l.leaguePoints desc")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        List<RankingDto> result = new ArrayList<RankingDto>();

        Iterator itr = resultList.iterator();

        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            League league = (League) obj[0];
            Summoner summoner = (Summoner) obj[1];

            result.add(new RankingDto(league, summoner));
        }

        return result;
    }


    public void insertByItemApiResult(LeagueItemApiResult result,
                                      String leagueId, String tier, String queueType) {
        League league = new League(result, leagueId, tier, queueType);
        em.persist(league);
    }

    public void updateByItemApiResult(League league, LeagueItemApiResult result,
                                      String leagueId, String tier, String queueType) {
        league.updateByItem(result, leagueId, tier, queueType);
    }

    public void insertByEntryApiResult(LeagueEntryApiResult result) {
        League league = new League(result);
        em.persist(league);
    }

    public void updateByEntryApiResult(League league, LeagueEntryApiResult result) {
        league.updateByEntry(result);
    }

}
