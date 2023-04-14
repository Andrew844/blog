package main.controllers;

import main.models.author.Author;
import main.models.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors/")
    public List<Author> list() {
        Iterable<Author> postIterable = authorRepository.findAll();
        ArrayList<Author> authors = new ArrayList<>();

        postIterable.forEach(authors::add);

        return authors;
    }

    @PostMapping("/authors/")
    public ResponseEntity<Author> add(@RequestBody Author author) {
        return new ResponseEntity<Author>(authorRepository.save(author), HttpStatus.CREATED);
    }

    @PostMapping("/authors/{id}")
    public ResponseEntity<Optional<Author>> get(@PathVariable("id") int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalAuthor);
        }

        return new ResponseEntity<Optional<Author>>(optionalAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Optional<Author>> delete(@PathVariable("id") int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalAuthor);
        }

        authorRepository.deleteById(id);

        return new ResponseEntity<Optional<Author>>(optionalAuthor, HttpStatus.OK);
    }

    @PutMapping("/authors/")
    public ResponseEntity<Optional<Author>> put(@RequestBody Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(author.getId());

        if (optionalAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalAuthor);
        }

        authorRepository.save(author);

        return new ResponseEntity<Optional<Author>>(optionalAuthor, HttpStatus.OK);
    }
}
