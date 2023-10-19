package duo.gg.server.comment;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public Comment findById(String commentId) {
        return em.find(Comment.class, commentId);
    }

    public void delete(Comment comment) {
        em.remove(comment);
    }

    public List<Comment> findByNamePaging(String name, Integer offset, Integer limit) {
        return em.createQuery("select c from Comment c", Comment.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
