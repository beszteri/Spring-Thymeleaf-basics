package com.codecool.demoWebApp.repositories;

import com.codecool.demoWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
