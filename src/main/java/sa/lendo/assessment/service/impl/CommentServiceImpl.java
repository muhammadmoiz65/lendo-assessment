package sa.lendo.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sa.lendo.assessment.entities.Comment;
import sa.lendo.assessment.entities.Post;
import sa.lendo.assessment.repository.CommentRepository;
import sa.lendo.assessment.repository.PostRepository;
import sa.lendo.assessment.service.CommentService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Comment addComment(Long postId, Comment comment) {
        Optional<Post> optionalPost = Optional.ofNullable(postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found")));
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            comment.setPost(post);
            return commentRepository.save(comment);
        }

        throw new RuntimeException("Post not found");
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findAllCommentsByPostPostId(postId);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }
}
