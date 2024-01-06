package duo.gg.server.account;

import duo.gg.server.account.entity.Account;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final EntityManager em;

    public void save(Account account) {
        em.persist(account);
    }

    public Optional<Account> findByPuuid(String puuid) {
        return em.createQuery("select a from Account a where a.puuid = :puuid", Account.class)
                .setParameter("puuid", puuid)
                .getResultList()
                .stream().findAny();
    }

    public Optional<Account> findByRiotId(String gameName, String tagLine) {
        return em.createQuery("select a from Account a where a.gameName = :gameName and a.tagLine = :tagLine", Account.class)
                .setParameter("gameName", gameName)
                .setParameter("tagLine", tagLine)
                .getResultList()
                .stream().findAny();
    }
}
