package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs4125.bookingapp.model.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    private IEncryptionService encryptor = new EncryptionService();

    /**
     * Registers the user
     * @param u User to be registered
     * @return SUCCESS: userid if registration was successful, else FAILURE: error code
     */
    @Override
    public String register(User u) {
        if (userRepository.existsByUsername(u.getUsername())) {
            return "FAILURE: 1";
        }
        u.setPassword(encryptor.encryptString(u.getPassword()));
        User resUser = userRepository.save(u);

        return "SUCCESS: " + resUser.getUser_id();
    }

    /**
     * Logs in the user
     * @param username The username
     * @param password The password
     * @return SUCCESS: userid if registration was successful, else FAILURE: error code
     */
    @Override
    public String login(String username, String password) {

        if(!userRepository.existsByUsername(username)) {
            return "FAILURE: 1";
        }

        User resUser = userRepository.findByUsernameAndAndPassword(username, encryptor.encryptString(password));
        if(resUser == null) {
            return "FAILURE: 2";
        }

        return "SUCCESS: " + resUser.getUser_id();
    }
}
