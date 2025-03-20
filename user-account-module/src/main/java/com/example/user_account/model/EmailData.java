package com.example.user_account.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Data
@Table(name="email_data")
public class EmailData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;

    @Column(name="email")
    private String email;
}
