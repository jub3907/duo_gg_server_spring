package duo.gg.server.post.contant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostRankType {
    SOLO("솔로랭크"),
    TEAM("자유랭크"),
    NORMAL("일반게임"),
    ARAM("칼바람");

    private final String rankType;

    @JsonCreator
    public static PostRankType from(String rankType) {
        for (PostRankType value : PostRankType.values()) {
            if (value.getRankType().equals(rankType)) {
                return value;
            }
        }
        return null;
    }
}
