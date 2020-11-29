package com.cs4125.bookingapp.services;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    @Override
    public String encryptString(String s) {
        return Hashing.sha256().hashString(s, StandardCharsets.UTF_8).toString();
    }
}
