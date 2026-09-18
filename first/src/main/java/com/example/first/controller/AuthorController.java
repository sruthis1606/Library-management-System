package com.example.first.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.model.Author;
import com.example.first.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return service.getAllAuthors();
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return service.addAuthor(author);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return service.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(
            @PathVariable Long id,
            @RequestBody Author author) {
        return service.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
        return "Author deleted successfully!";
    }
}