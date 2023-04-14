package main.controllers;

import main.models.post.Post;
import main.models.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/")
    public List<Post> list() {
        Iterable<Post> postIterable = postRepository.findAll();
        ArrayList<Post> posts = new ArrayList<>();

        postIterable.forEach(posts::add);

        return posts;
    }

    @PostMapping("/posts/")
    public ResponseEntity<Post> add(@RequestBody Post post) {
        return new ResponseEntity<Post>(postRepository.save(post), HttpStatus.CREATED);
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> get(@PathVariable("id") int id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalPost);
        }

        return new ResponseEntity<Optional<Post>>(optionalPost, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> delete(@PathVariable("id") int id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalPost);
        }

        postRepository.deleteById(id);

        return new ResponseEntity<Optional<Post>>(optionalPost, HttpStatus.OK);
    }

    @PutMapping("/posts/")
    public ResponseEntity<Optional<Post>> put(@RequestBody Post book) {
        Optional<Post> optionalPost = postRepository.findById(book.getId());

        if (optionalPost.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalPost);
        }

        postRepository.save(book);

        return new ResponseEntity<Optional<Post>>(optionalPost, HttpStatus.OK);
    }
}
