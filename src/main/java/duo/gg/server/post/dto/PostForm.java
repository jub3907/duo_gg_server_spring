package duo.gg.server.post.dto;

import duo.gg.server.post.contant.PostPosition;
import duo.gg.server.post.contant.PostRankType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostForm {

    private PostRankType rankType;

    private PostPosition position;

    @NotBlank(message = "이름을 입력 해주세요.")
    private String name;

    @NotNull
    private String tier;

    @NotNull
    private String body;
}
