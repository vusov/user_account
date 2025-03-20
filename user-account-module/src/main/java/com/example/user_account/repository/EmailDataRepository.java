package com.example.user_account.repository;

import com.example.user_account.model.EmailData;
import com.example.user_account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface EmailDataRepository extends JpaRepository<EmailData, BigInteger>, JpaSpecificationExecutor<EmailData> {
}
