package com.example.springb.repository;

import com.example.springb.vo.User;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository{

    private static Map<BigInteger, User> store = new HashMap<>();

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(BigInteger userNum) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByName(String userName) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
