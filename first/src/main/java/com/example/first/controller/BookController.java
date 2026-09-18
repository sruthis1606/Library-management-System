
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

import com.example.first.model.Book;
import com.example.first.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // GET - View all books
    @GetMapping
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    // POST - Add a book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    // GET - Find book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    // PUT - Update a book
    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable Long id,
            @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    // DELETE - Delete a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "Book deleted successfully!";
    }
}