package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}