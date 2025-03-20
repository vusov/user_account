package com.example.user_account.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name="phone_data", schema = "user_account")
@Builder
public class PhoneData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;

    @Column(name="phone")
    private String phone;
}
