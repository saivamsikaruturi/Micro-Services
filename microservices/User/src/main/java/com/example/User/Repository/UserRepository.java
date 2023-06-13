package com.example.User.Repository;

import com.example.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUserId(BigInteger userId);
}