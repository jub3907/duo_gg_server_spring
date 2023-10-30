package duo.gg.server.post;

import duo.gg.server.post.dto.PostDto;
import duo.gg.server.post.dto.PostForm;
import duo.gg.server.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public void save(PostForm form) {
        Post post = new Post(form);
        repository.save(post);
    }

    public List<PostDto> findByPage(int offset, int limit) {
        return repository.findByPage(offset, limit)
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
}
