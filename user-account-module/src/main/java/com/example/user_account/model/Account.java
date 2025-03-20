package com.example.user_account.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @JoinColumn(name="user_id")
    @OneToOne
    private User user;

    @Column(name="balance")
    private BigDecimal balance;
}
