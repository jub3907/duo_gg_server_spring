package duo.gg.server.post.contant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostPosition {
    ALL("모든 포지션"),
    TOP("탑"),
    MID("미드"),
    JUNGLE("정글"),
    AD("원딜"),
    SUPPORT("서폿");

    private final String position;

    @JsonCreator
    public static PostPosition from(String position) {
        for (PostPosition value : PostPosition.values()) {
            if (value.getPosition().equals(position)) {
                return value;
            }
        }
        return null;
    }
}
