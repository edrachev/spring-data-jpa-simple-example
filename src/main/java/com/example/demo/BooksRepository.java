package com.example.demo;

import org.springframework.data.repository.CrudRepository;

interface BooksRepository extends CrudRepository<Book, Long> {
}
