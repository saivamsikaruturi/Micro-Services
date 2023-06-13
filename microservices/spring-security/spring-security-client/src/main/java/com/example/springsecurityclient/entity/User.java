package com.example.springsecurityclient.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "security")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;

    @Column(length = 60)
    private String password;

    private String role;
    private boolean enabled = false;
}