package com.codecool.demoWebApp.repositories;

import com.codecool.demoWebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
