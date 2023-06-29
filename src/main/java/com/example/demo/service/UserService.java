package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll(){return userRepository.findAll();}
public User findById(Long id){return userRepository.getReferenceById(id);}
    public void addUser(User user){userRepository.save(user);}
public void deliteUser(Long id){userRepository.deletedById(id);}
}
