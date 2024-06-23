package sa.lendo.assessment.service.impl;

import sa.lendo.assessment.entities.User;
import sa.lendo.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sa.lendo.assessment.entities.Post;
import sa.lendo.assessment.repository.PostRepository;
import sa.lendo.assessment.service.PostService;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post addPost(Long userId, Post post) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserUserId(userId);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
