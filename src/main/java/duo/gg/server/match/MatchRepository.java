package duo.gg.server.match;

import duo.gg.server.api.dto.match.MatchApiResult;
import duo.gg.server.match.entity.Match;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Match> findByIds(List<String> matchIds) {
        return em.createQuery("select m from Match m where m.id in :ids", Match.class)
                .setParameter("ids", matchIds)
                .getResultList();
    }

    public Optional<Match> findById(String matchId) {
        return Optional.ofNullable(em.find(Match.class, matchId));
    }

    public void updateMatchesByApiResults(List<MatchApiResult> matchApiResults) {
        matchApiResults.stream()
                .map(Match::new)
                .toList()
                .forEach(em::persist);

    }

}
