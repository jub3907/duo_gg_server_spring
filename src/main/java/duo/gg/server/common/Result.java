package duo.gg.server.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class Result<T> {

    private List<T> data;

    public Result(List<T> data) {
        this.data = data;
    }
}
