package com.example.User.Rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private BigInteger id;
    private String name;
    private String address;
    private String code;
}