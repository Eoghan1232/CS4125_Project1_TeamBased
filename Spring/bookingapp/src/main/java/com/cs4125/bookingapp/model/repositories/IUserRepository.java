package com.cs4125.bookingapp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cs4125.bookingapp.model.entities.User;

public interface IUserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username);
    User findByUsernameAndAndPassword(String username, String password);
}
