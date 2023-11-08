package duo.gg.server.comment;

import duo.gg.server.comment.entity.Comment;
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

    public Comment findById(Long commentId) {
        return em.find(Comment.class, commentId);
    }

    public void delete(Comment comment) {
        em.remove(comment);
    }

    public List<Comment> findByPuuidPaging(String puuid, Integer offset, Integer limit) {
        return em.createQuery("select c from Comment c where puuid = :puuid", Comment.class)
                .setParameter("puuid", puuid)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
