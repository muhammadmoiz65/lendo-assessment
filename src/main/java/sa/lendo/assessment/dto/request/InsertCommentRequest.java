package sa.lendo.assessment.dto.request;

import sa.lendo.assessment.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class InsertCommentRequest {
    private Long postId;
    private Comment comment;
}
