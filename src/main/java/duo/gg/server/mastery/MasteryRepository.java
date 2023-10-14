package duo.gg.server.mastery;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MasteryRepository {

    private final EntityManager em;

    public List<Mastery> findByPuuid(String puuid) {
        //TODO
        return null;
    }

    public List<Mastery> findBySummonerId(String summonerId) {
        //TODO
        return null;
    }

    public List<Mastery> findByName(String name, int limit) {
        //TODO
        return null;
    }
}
