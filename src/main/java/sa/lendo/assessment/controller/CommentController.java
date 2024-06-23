package sa.lendo.assessment.controller;

import sa.lendo.assessment.dto.request.InsertCommentRequest;
import sa.lendo.assessment.entities.Comment;
import sa.lendo.assessment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/v2/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> addCommentToPost(@RequestBody InsertCommentRequest commentDto) {
        Comment savedComment = commentService.addComment(commentDto.getPostId(), commentDto.getComment());
        if (savedComment != null) {
            return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Object> getCommentById(@RequestParam(required = false) Long commentId, @RequestParam(required = false) Long postId) {
        if (commentId != null) {
                Optional<Comment> comment =  commentService.getCommentById(commentId);
                return comment.isPresent() ? ResponseEntity.ok(comment.get()) : ResponseEntity.notFound().build();
        } else if (postId != null) {
            List<Comment> comments = commentService.getCommentsByPostId(postId);
            return !comments.isEmpty() ? ResponseEntity.ok(comments): ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(commentService.getAllComments());
    }
}
