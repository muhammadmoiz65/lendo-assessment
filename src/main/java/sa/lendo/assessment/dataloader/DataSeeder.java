package sa.lendo.assessment.dataloader;

import sa.lendo.assessment.entities.Comment;
import sa.lendo.assessment.entities.Post;
import sa.lendo.assessment.entities.User;
import sa.lendo.assessment.service.CommentService;
import sa.lendo.assessment.service.PostService;
import sa.lendo.assessment.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DataSeeder {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @PostConstruct
    public void loadData() {
        try {
            User user1  = User.builder().firstName("Geoff").lastName("Ellis")
                    .email("geoff@gmail.com").password(passwordEncoder.encode("1234"))
                    .build();
            userService.saveUser(user1);

            Post post1 = Post.builder()
                    .title("Post Title 1")
                    .content("Content of post 1")
                    .createdAt(new Date())
                    .user(user1)
                    .build();
            postService.addPost(user1.getUserId(), post1);

            Comment comment1 = Comment.builder()
                    .content("Comment 1 on Post 1")
                    .createdAt(new Date())
                    .post(post1)
                    .build();
            commentService.addComment(post1.getPostId(), comment1);

            Comment comment2 = Comment.builder()
                    .content("Comment 2 on Post 1")
                    .createdAt(new Date())
                    .post(post1)
                    .build();
            commentService.addComment(post1.getPostId(), comment2);

            User user2 = User.builder().firstName("Fran").lastName("Huddson")
                    .email("fran@gmail.com").password(passwordEncoder.encode("1234"))
                    .build();
            userService.saveUser(user2);
            Post post2 = Post.builder()
                    .title("Post Title 2")
                    .content("Content of post 2")
                    .createdAt(new Date())
                    .user(user2)
                    .build();
            postService.addPost(user2.getUserId(), post2);

            Comment comment3 = Comment.builder()
                    .content("Comment 1 on Post 2")
                    .createdAt(new Date())
                    .post(post2)
                    .build();
            commentService.addComment(post2.getPostId(), comment3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
