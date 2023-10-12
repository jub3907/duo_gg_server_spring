package duo.gg.server.post.dto;

import duo.gg.server.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@ToString
public class PostDto {

    private String rankType;
    private String position;
    private String name;
    private String tier;
    private String body;
    private LocalDateTime createdDate;

    public PostDto(Post entity) {
        this.rankType = entity.getRankType().getRankType();
        this.position = entity.getPosition().getPosition();

        this.name = entity.getName();
        this.tier = entity.getTier();
        this.body = entity.getBody();

        this.createdDate = entity.getCreatedDate();
    }
}
