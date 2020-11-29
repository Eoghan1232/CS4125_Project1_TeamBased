package com.cs4125.bookingapp.services;

import org.springframework.stereotype.Service;

@Service
public interface EncryptionService {
    String encryptString(String s);
}
