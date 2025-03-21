package com.example.user_account.repository;

import com.example.user_account.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, BigInteger>, JpaSpecificationExecutor<User> {
    @Query(value = "select distinct u from User u" +
            " left join EmailData e on u = e.user" +
            " left join PhoneData p on u = p.user")
    Page<User> findUsers(Specification<User> spec, Pageable pageable);

    Optional<User> findByName(String name);

    boolean existsByName(String name);

    @Query(value = "select distinct u from User u" +
            " left join EmailData e on u = e.user" +
            " where e.email = ?1")
    boolean existsByEmail(String email);

}
