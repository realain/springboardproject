package com.example.springb.service;

import com.example.springb.domain.User;
import com.example.springb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserService implements UserRepository {

    private UserRepository userRepository;

    @Override
    public List<User> getList() {
        return userRepository.getList();
    }

    @Override
    public User get(BigInteger userNum) {
        return userRepository.get(userNum);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(BigInteger userNum) {
        userRepository.delete(userNum);
    }
}
