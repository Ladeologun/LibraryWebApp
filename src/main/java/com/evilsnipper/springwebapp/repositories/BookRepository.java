package com.evilsnipper.springwebapp.repositories;

import com.evilsnipper.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
