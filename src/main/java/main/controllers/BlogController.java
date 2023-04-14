package main.controllers;

import main.models.blog.Blog;
import main.models.blog.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs/")
    public List<Blog> list() {
        Iterable<Blog> postIterable = blogRepository.findAll();
        ArrayList<Blog> blogs = new ArrayList<>();

        postIterable.forEach(blogs::add);

        return blogs;
    }

    @PostMapping("/blogs/")
    public ResponseEntity<Blog> add(@RequestBody Blog blog) {
        return new ResponseEntity<Blog>(blogRepository.save(blog), HttpStatus.CREATED);
    }

    @PostMapping("/blogs/{id}")
    public ResponseEntity<Optional<Blog>> get(@PathVariable("id") int id) {
        Optional<Blog> optionalBlog = blogRepository.findById(id);

        if (optionalBlog.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalBlog);
        }

        return new ResponseEntity<Optional<Blog>>(optionalBlog, HttpStatus.OK);
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Optional<Blog>> delete(@PathVariable("id") int id) {
        Optional<Blog> optionalBlog = blogRepository.findById(id);

        if (optionalBlog.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalBlog);
        }

        blogRepository.deleteById(id);

        return new ResponseEntity<Optional<Blog>>(optionalBlog, HttpStatus.OK);
    }

    @PutMapping("/blogs/")
    public ResponseEntity<Optional<Blog>> put(@RequestBody Blog blog) {
        Optional<Blog> optionalBlog = blogRepository.findById(blog.getId());

        if (optionalBlog.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalBlog);
        }

        blogRepository.save(blog);

        return new ResponseEntity<Optional<Blog>>(optionalBlog, HttpStatus.OK);
    }
}
