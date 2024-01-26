package com.evilsnipper.springwebapp.services;

import com.evilsnipper.springwebapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
