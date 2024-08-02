package com.example.Enkel_Library_Managment_System.repository;


import com.example.Enkel_Library_Managment_System.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{ 'tags': { $all: ?0 } }")
    List<Book> findByTags(Set<String> tags);
}
