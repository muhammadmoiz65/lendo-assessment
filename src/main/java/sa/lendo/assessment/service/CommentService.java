package sa.lendo.assessment.service;

import sa.lendo.assessment.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment addComment(Long postId, Comment comment);

    List<Comment> getCommentsByPostId(Long postId);

    List<Comment> getAllComments();

    Optional<Comment> getCommentById(Long commentId);
}
