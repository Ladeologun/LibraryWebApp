package com.evilsnipper.springwebapp.repositories;

import com.evilsnipper.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
