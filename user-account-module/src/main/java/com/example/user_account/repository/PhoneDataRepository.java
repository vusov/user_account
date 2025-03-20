package com.example.user_account.repository;

import com.example.user_account.model.PhoneData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PhoneDataRepository extends JpaRepository<PhoneData, BigInteger> {
}
