package duo.gg.server.post.entity;

import duo.gg.server.post.contant.PostPosition;
import duo.gg.server.post.contant.PostRankType;
import duo.gg.server.post.dto.PostForm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private PostRankType rankType;

    @Enumerated(EnumType.STRING)
    private PostPosition position;

    @NotNull
    private String name;

    @NotNull
    private String tier;

    @NotNull
    private String body;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    public Post(PostForm form) {
        this.rankType = form.getRankType();
        this.position = form.getPosition();
        this.name = form.getName();
        this.tier = form.getTier();
        this.body = form.getBody();
    }
}
