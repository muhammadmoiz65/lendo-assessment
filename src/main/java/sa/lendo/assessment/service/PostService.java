package sa.lendo.assessment.service;

import sa.lendo.assessment.entities.Post;
import sa.lendo.assessment.entities.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public Post addPost(Long userId, Post post);

    List<Post> getAllPosts();

    Optional<Post> getPostById(Long id);

    List<Post> getPostsByUserId(Long userId);

    User getUserById(Long userId);
}
