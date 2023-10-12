package duo.gg.server.comment.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumMap;

@Getter
@AllArgsConstructor
public enum CommentPosition {
    ALL("모든 포지션"),
    TOP("탑"),
    MID("미드"),
    JUNGLE("정글"),
    AD("원딜"),
    SUPPORT("서폿");

    private final String position;

    @JsonCreator
    public static CommentPosition from(String position) {
        for (CommentPosition value : CommentPosition.values()) {
            if (value.getPosition().equals(position)) {
                return value;
            }
        }
        return null;
    }
}
