package duo.gg.server.mastery;

import duo.gg.server.api.dto.mastery.MasteryApiResult;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MasteryRepository {

    private final EntityManager em;

    public List<Mastery> findByPuuid(String puuid) {
        return em.createQuery("select m from Mastery m where m.id.puuid = :puuid order by m.championPoints desc", Mastery.class)
                .setParameter("puuid", puuid)
                .getResultList();
    }

    public List<Mastery> findByPuuid(String puuid, Integer limit) {
        return em.createQuery("select m from Mastery m where m.id.puuid = :puuid order by m.championPoints desc", Mastery.class)
                .setParameter("puuid", puuid)
                .setMaxResults(limit)
                .getResultList();
    }

    public List<Mastery> findBySummonerId(String summonerId) {
        return em.createQuery("select m from Mastery m where m.summonerId = :summonerId order by m.championPoints desc", Mastery.class)
                .setParameter("summonerId", summonerId)
                .getResultList();
    }

    public List<Mastery> findBySummonerId(String summonerId, Integer limit) {
        return em.createQuery("select m from Mastery m where m.summonerId = :summonerId order by m.championPoints desc", Mastery.class)
                .setParameter("summonerId", summonerId)
                .setMaxResults(limit)
                .getResultList();
    }

    public List<Mastery> findByName(String name) {
        return em.createQuery("select m from Summoner s, Mastery m where s.name = :name and s.puuid = m.id.puuid order by m.championPoints desc", Mastery.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Mastery> findByName(String name, Integer limit) {
        return em.createQuery("select m from Summoner s, Mastery m where s.name = :name and s.puuid = m.id.puuid order by m.championPoints desc", Mastery.class)
                .setParameter("name", name)
                .setMaxResults(limit)
                .getResultList();
    }

    public void insertMasteriesByApiResults(List<MasteryApiResult> apiResults) {
        for (MasteryApiResult apiResult : apiResults) {
            Mastery mastery = new Mastery(apiResult);
            em.persist(mastery);
        }
    }

    public void insertMastery(Mastery mastery) {
        em.persist(mastery);
    }

    public void upsertMasteries(List<MasteryApiResult> apiResults, List<Mastery> findMastery) {
        for (MasteryApiResult apiResult : apiResults) {
            Long championId = apiResult.getChampionId();
            Optional<Mastery> savedMastery = findMastery.stream().filter(mastery -> mastery.getId().getChampionId().equals(championId)).findFirst();
            if (savedMastery.isEmpty()) {
                insertMastery(new Mastery(apiResult));
            } else {
                savedMastery.get().updateByApiResult(apiResult);
            }
        }
    }
}
