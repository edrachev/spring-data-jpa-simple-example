package com.example.demo;

import org.springframework.data.repository.CrudRepository;

interface AuthorsRepository extends CrudRepository<Author, Long> {
}
