package com.cs4125.bookingapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cs4125.bookingapp.entities.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

}
