package com.example.Enkel_Library_Managment_System.repository;

import com.example.Enkel_Library_Managment_System.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
