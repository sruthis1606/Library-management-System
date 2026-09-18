
package com.example.first.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.model.Book;
import com.example.first.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    // GET - View all books
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // POST - Add a book
    public Book addBook(Book book) {
        return repository.save(book);
    }

    // GET - Find book by ID
    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // PUT - Update a book
    public Book updateBook(Long id, Book newBook) {
        Book book = repository.findById(id).orElse(null);

        if (book != null) {
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setPrice(newBook.getPrice());

            return repository.save(book);
        }

        return null;
    }

    // DELETE - Delete a book
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}