
package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}