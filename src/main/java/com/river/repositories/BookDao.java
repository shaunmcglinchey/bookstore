package com.river.repositories;

import com.river.beans.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDao extends MongoRepository<Book, String> {
}