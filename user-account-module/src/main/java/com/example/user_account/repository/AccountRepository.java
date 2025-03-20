package com.example.user_account.repository;

import com.example.user_account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccountRepository extends JpaRepository<Account, BigInteger> {
}
