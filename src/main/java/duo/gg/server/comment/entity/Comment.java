package duo.gg.server.comment.entity;

import duo.gg.server.comment.constant.CommentPosition;
import duo.gg.server.comment.constant.CommentRankType;
import duo.gg.server.comment.dto.CommentForm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private CommentRankType rankType;

    @Enumerated(EnumType.STRING)
    private CommentPosition position;

    @NotNull
    private String name;

    @NotNull
    private String tier;

    @NotNull
    private String body;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    public Comment(CommentForm form) {
        this.rankType = form.getRankType();
        this.position = form.getPosition();
        this.name = form.getName();
        this.tier = form.getTier();
        this.body = form.getBody();
    }
}
