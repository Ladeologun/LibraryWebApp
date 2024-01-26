package com.evilsnipper.springwebapp.services;

import com.evilsnipper.springwebapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
