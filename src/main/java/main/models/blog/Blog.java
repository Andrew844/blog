package main.models.blog;

import jakarta.persistence.*;
import main.models.post.Post;
import main.models.author.Author;

import java.util.List;

@Entity
public class Blog {
    private String title;

    @OneToOne
    private Author author;
    @OneToMany
    private List<Post> posts;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
