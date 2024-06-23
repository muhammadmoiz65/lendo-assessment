package sa.lendo.assessment.controller;

import sa.lendo.assessment.dto.request.InsertPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.lendo.assessment.entities.Post;
import sa.lendo.assessment.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/v2/posts")

public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> insertPost(@RequestBody InsertPostRequest postDto) {
        Post savedPost = postService.addPost(postDto.getUserId(), postDto.getPost());
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getPostById(@RequestParam(required = false) Long postId, @RequestParam(required = false) Long userId) {
        if (postId != null) {
            Optional<Post> post = postService.getPostById(postId);
            return post.isPresent()? ResponseEntity.ok(post): ResponseEntity.notFound().build();
        }
        else if(userId != null) {
            List<Post> posts = postService.getPostsByUserId(userId);
            return !posts.isEmpty()? ResponseEntity.ok(posts): ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( postService.getAllPosts());
    }
}
