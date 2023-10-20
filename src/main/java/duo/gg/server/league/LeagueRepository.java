package duo.gg.server.league;

import duo.gg.server.api.dto.league.LeagueEntryApiResult;
import duo.gg.server.api.dto.league.LeagueItemApiResult;
import duo.gg.server.constant.QueueEnum;
import duo.gg.server.league.entry.League;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public List<League> findLeaguesBySummonerId(String summonerId) {
        return em.createQuery("select l from League l where l.summonerId = :summonerId", League.class)
                .setParameter("summonerId", summonerId)
                .getResultList();
    }


    public void insertByItemApiResult(LeagueItemApiResult result,
                                      String leagueId, String tier, String queueType) {
        League league = new League(result, leagueId, tier, queueType);
        em.persist(league);
    }

    public void updateByItemApiResult(League league, LeagueItemApiResult result) {
        league.updateByItem(result);
    }

    public void insertByEntryApiResult(LeagueEntryApiResult result) {
        League league = new League(result);
        em.persist(league);
    }

    public void updateByEntryApiResult(League league, LeagueEntryApiResult result) {
        league.updateByEntry(result);
    }

}
