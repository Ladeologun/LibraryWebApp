package com.evilsnipper.springwebapp.repositories;

import com.evilsnipper.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
