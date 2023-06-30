package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){return userRepository.findAll();}
public Optional<User> findByName(String name){
    return userRepository.getReferenceByName(name);
    }
    public void addUser(User user){userRepository.save(user);}
public void deleteUser(Long id){userRepository.deletedById(id);}
}
