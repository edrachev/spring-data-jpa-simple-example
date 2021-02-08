package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class Resource {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    @PostConstruct
    public void init() {
        Author fowler = new Author("Fowler");
        authorsRepository.save(fowler);

        Book patterns = new Book("P of EAA", fowler);
        Book refactoring = new Book("Refactoring", fowler);
        Book uml = new Book("Uml Distilled", fowler);

        booksRepository.saveAll(List.of(patterns, refactoring, uml));

        Author bob = new Author("Uncle Bob");
        authorsRepository.save(bob);

        Book code = new Book("Clean Code", bob);
        Book coder = new Book("Clean Coder", bob);
        Book arch = new Book("Clean Architecture", bob);

        booksRepository.saveAll(List.of(code, coder, arch));

        Author bruce = new Author("Eckel");
        authorsRepository.save(bruce);

        Book java = new Book("Java", bruce);
        Book c = new Book("C", bruce);
        Book cpp = new Book("CPP", bruce);

        booksRepository.saveAll(List.of(java, c, cpp));
    }

    @GetMapping("/books")
    public Iterable<Book> readAllBooks() {
        return booksRepository.findAll();
    }

    @GetMapping("/authors")
    public Iterable<Author> readAllBAuthors() {
        return authorsRepository.findAll();
    }
}
