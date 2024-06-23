package sa.lendo.assessment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sa.lendo.assessment.entities.Post;
import sa.lendo.assessment.entities.User;
import sa.lendo.assessment.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/v2/users")
@RequiredArgsConstructor
public class AdminService {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> getUser(@RequestParam(required = false) Long userId) {
        if (userId != null) {
            Optional<User> user = userService.getUserById(userId);
            return user.isPresent()? ResponseEntity.ok(user): ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( userService.getAllUsers());
    }
}
