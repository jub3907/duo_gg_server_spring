package duo.gg.server.match;

import duo.gg.server.api.dto.match.MatchApiResult;
import duo.gg.server.match.entity.MatchInfo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MatchRepository {

    private final EntityManager em;

    public List<String> findMatchIdsInDb(List<String> matchIds) {
        return em.createQuery("select m.id from Match m where m.id in :ids", String.class)
                .setParameter("ids", matchIds)
                .getResultList();
    }

    public List<MatchInfo> findByIds(List<String> matchIds) {
        return em.createQuery("select m from Match m where m.id in :ids", MatchInfo.class)
                .setParameter("ids", matchIds)
                .getResultList();
    }

    public Optional<MatchInfo> findById(String matchId) {
        return Optional.ofNullable(em.find(MatchInfo.class, matchId));
    }

    public void updateMatchesByApiResults(List<MatchApiResult> matchApiResults) {
        matchApiResults.stream()
                .map(MatchInfo::new)
                .toList()
                .forEach(em::persist);

    }

}
