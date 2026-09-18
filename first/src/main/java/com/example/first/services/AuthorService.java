package com.example.first.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.model.Author;
import com.example.first.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public Author addAuthor(Author author) {
        return repository.save(author);
    }

    public Author getAuthorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Author updateAuthor(Long id, Author newAuthor) {
        Author author = repository.findById(id).orElse(null);

        if (author != null) {
            author.setName(newAuthor.getName());
            author.setEmail(newAuthor.getEmail());
            author.setBiography(newAuthor.getBiography());

            return repository.save(author);
        }

        return null;
    }

    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }
}