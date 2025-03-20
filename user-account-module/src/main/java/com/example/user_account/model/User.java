package com.example.user_account.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@Table(name="\"USER\"", schema = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(name="name")
    private String name;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name="password")
    private String password;
}
