package com.geektext.geektext;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody Comment comment) {
        if (comment.getUserId() == null || comment.getBookId() == null) {
            return ResponseEntity.badRequest().body("User ID and Book ID are required");
        }
        if (comment.getContent() == null || comment.getContent().isBlank()) {
            return ResponseEntity.badRequest().body("Comment content cannot be empty");
        }
        commentRepository.save(comment);
        return ResponseEntity.ok("Comment submitted successfully");
    }
}
