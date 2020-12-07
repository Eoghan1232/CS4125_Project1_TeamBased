package com.cs4125.bookingapp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cs4125.bookingapp.model.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username);
    boolean existsByUsernameOrEmail(String username, String email);
    User findByUsernameAndPassword(String username, String password);
}
