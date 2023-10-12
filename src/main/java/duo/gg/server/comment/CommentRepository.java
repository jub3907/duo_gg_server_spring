package duo.gg.server.comment;

import duo.gg.server.comment.entity.Comment;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public List<Comment> findByPage(int offset, int limit) {
        return em.createQuery("select c from Comment c order by c.createdDate desc", Comment.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
