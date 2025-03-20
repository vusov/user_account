package com.example.user_account.repository;

import com.example.user_account.model.EmailData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EmailDataRepository extends JpaRepository<EmailData, BigInteger> {
}
