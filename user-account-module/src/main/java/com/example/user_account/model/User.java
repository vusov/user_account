package com.example.user_account.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@Table(name="user")
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
