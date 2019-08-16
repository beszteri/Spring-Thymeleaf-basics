package com.codecool.demoWebApp.bootstrap;

import com.codecool.demoWebApp.model.Author;
import com.codecool.demoWebApp.model.Book;
import com.codecool.demoWebApp.model.Publisher;
import com.codecool.demoWebApp.repositories.AuthorRepository;
import com.codecool.demoWebApp.repositories.BookRepository;
import com.codecool.demoWebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("asd", "1234", publisher);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book aaa = new Book("rodrodor", "4321", publisher);
        rod.getBooks().add(aaa);

        authorRepository.save(rod);
        bookRepository.save(aaa);

    }
}
