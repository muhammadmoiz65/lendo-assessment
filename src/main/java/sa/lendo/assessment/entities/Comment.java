package sa.lendo.assessment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "postId")
    @JsonBackReference
    private Post post;
}
