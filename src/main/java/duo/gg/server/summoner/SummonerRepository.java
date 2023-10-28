package duo.gg.server.summoner;

import duo.gg.server.summoner.entity.Summoner;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SummonerRepository {

    private final EntityManager em;

    public void save(Summoner summoner) {
        em.persist(summoner);
    }

    public Optional<Summoner> findById(String summonerId) {
        return Optional.ofNullable(em.find(Summoner.class, summonerId));
    }

    public Optional<Summoner> findByAccountId(String accountId) {
        return em.createQuery("select s from Summoner s where s.accountId = :accountId", Summoner.class)
                .setParameter("accountId", accountId)
                .getResultList()
                .stream().findAny();
    }

    public Optional<Summoner> findByName(String name) {
        return em.createQuery("select s from Summoner s where s.name = :name", Summoner.class)
                .setParameter("name", name)
                .getResultList()
                .stream().findAny();
    }

    public Optional<Summoner> findByPuuid(String puuid) {
        return em.createQuery("select s from Summoner s where s.puuid = :puuid", Summoner.class)
                .setParameter("puuid", puuid)
                .getResultList()
                .stream().findAny();
    }

    public List<Summoner> findByNames(List<String> names) {
        return em.createQuery("select s from Summoner s where s.name in :names", Summoner.class)
                .setParameter("names", names)
                .getResultList();
    }
}
