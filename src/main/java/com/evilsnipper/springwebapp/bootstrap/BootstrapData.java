package com.evilsnipper.springwebapp.bootstrap;

import com.evilsnipper.springwebapp.domain.Author;
import com.evilsnipper.springwebapp.domain.Book;
import com.evilsnipper.springwebapp.domain.Publisher;
import com.evilsnipper.springwebapp.repositories.AuthorRepository;
import com.evilsnipper.springwebapp.repositories.BookRepository;
import com.evilsnipper.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author james = new Author();
        james.setFirstName("james");
        james.setLastName("patterson");

        Author adichie = new Author();
        adichie.setFirstName("Adichie");
        adichie.setLastName("chimanmanda");

        Author savedJames = authorRepository.save(james);
        Author savedAdichie = authorRepository.save(adichie);

        Book book1 = new Book();
        book1.setTitle("the seventh confession");
        book1.setIsbn("123456");
        book1.getAuthors().add(savedJames);

        Book book2 = new Book();
        book2.setTitle("Half of a yellow sun");
        book2.setIsbn("234567");
        book2.getAuthors().add(savedAdichie);

        Book savedbook1 = bookRepository.save(book1);
        Book savedbook2 = bookRepository.save(book2);

        savedJames.getBooks().add(savedbook1);
        savedAdichie.getBooks().add(savedbook2);

        authorRepository.save(savedJames);
        authorRepository.save(savedAdichie);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Evans inc");
        publisher1.getBooks().add(savedbook1);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("shakespare ltd");
        publisher2.getBooks().add(savedbook2);

        Publisher savedPublisher1 = publisherRepository.save(publisher1);
        Publisher savedPublisher2 = publisherRepository.save(publisher2);

        savedbook1.setPublisher(savedPublisher1);
        savedbook2.setPublisher(savedPublisher2);
        bookRepository.save(savedbook1);
        bookRepository.save(savedbook2);


        System.out.println("number of authors "+ authorRepository.count());
        System.out.println("number of books "+ bookRepository.count());
        System.out.println("number of publisher "+ publisherRepository.count());


    }
}
