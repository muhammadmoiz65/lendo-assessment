package sa.lendo.assessment.dto.request;

import sa.lendo.assessment.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class InsertPostRequest {
    private Long userId;
    private Post post;
}
