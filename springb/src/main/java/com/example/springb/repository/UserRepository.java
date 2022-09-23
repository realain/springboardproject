package com.example.springb.repository;

import com.example.springb.vo.User;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    User save(User user);
    Optional<User> findById(BigInteger userNum);
    Optional<User> findByName(String userName);
    List<User> findAll();
}
