package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs4125.bookingapp.model.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private EncryptionService encryptor = new EncryptionServiceImpl();

    /**
     * Registers the user
     * @param u User to be registered
     * @return SUCCESS: userid if registration was successful, else FAILURE: error code
     */
    @Override
    public String register(User u) {
        if(u == null) {
            return "FAILURE: 1";
        }
        if (userRepository.existsByUsername(u.getUsername())) {
            return "FAILURE: 2";
        }
        u.setUsername(u.getUsername().toLowerCase());
        u.setPassword(encryptor.encryptString(u.getPassword()));
        User resUser = userRepository.save(u);

        return "SUCCESS: " + resUser.getUser_id();
    }

    /**
     * Logs in the user
     * @param name username or email
     * @param password The password
     * @return SUCCESS: userid if login was successful, else FAILURE: error code
     */
    @Override
    public String login(String name, String password) {
        // Provided name could be the username or email
        name = name.toLowerCase();
        if(!userRepository.existsByUsernameOrEmail(name, name)) {
            return "FAILURE: 1";
        }

        User resUser = userRepository.findByUsernameAndPassword(name, encryptor.encryptString(password));
        if(resUser == null) {
            return "FAILURE: 2";
        }

        return "SUCCESS: " + resUser.getUser_id();
    }
}
