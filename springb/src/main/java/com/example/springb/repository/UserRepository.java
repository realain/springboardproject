package com.example.springb.repository;

import com.example.springb.vo.User;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UserRepository {

    List<User> getList();

    User get(BigInteger userNum);

    void save(User user);

    void update(User user);

    void delete(BigInteger userNum);
}
