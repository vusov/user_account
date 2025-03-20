package com.example.user_account.service;

import com.example.user_account.model.PhoneData;
import com.example.user_account.model.User;
import com.example.user_account.repository.PhoneDataRepository;
import com.example.user_account.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@AllArgsConstructor
public class PhoneService {
    private final PhoneDataRepository phoneDataRepository;
    private final UserRepository userRepository;

    public void createPhone(BigInteger user_id, String phoneNumber) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User not found"));
        PhoneData phoneData = PhoneData.builder()
                .user(user)
                .phone(phoneNumber)
                .build();
        phoneDataRepository.save(phoneData);
    }
}
