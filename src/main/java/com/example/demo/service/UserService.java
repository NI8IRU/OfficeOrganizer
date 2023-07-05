package com.example.demo.service;

import com.example.demo.dto.secretary.GetSecretaryDto;
import com.example.demo.dto.user.AddUserDto;
import com.example.demo.dto.user.GetUserDto;
import com.example.demo.entity.Secretary;
import com.example.demo.entity.User;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.repository.PrenotationRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private PrenotationRepository prenotationRepository;

    public UserService(UserRepository userRepository, PrenotationRepository prenotationRepository) {
        this.userRepository = userRepository;
        this.prenotationRepository = prenotationRepository;
    }

    public AddUserDto addUser(AddUserDto addUserDto) {
        User user = new User();
        user.setId(user.getId());
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setEmail(user.getEmail());
        userRepository.save(user);
        addUserDto.setId(user.getId());
        addUserDto.setName(user.getName());
        addUserDto.setSurname(user.getSurname());
        addUserDto.setEmail(user.getEmail());
        return addUserDto;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByName(String name) {
        return userRepository.getReferenceByName(name);
    }

    public void updateUser(Long id, AddUserDto addUserDto) {
        userRepository.deletedById(id);
        User user = new User();
        addUserDto.setId(user.getId());
        addUserDto.setName(user.getName());
        addUserDto.setSurname(user.getSurname());
        addUserDto.setEmail(user.getEmail());
        userRepository.save(user);
    }

    public GetUserDto logicalDeleteSecretaryById(Long id) {
        Optional<User> user = userRepository.findById(id);
        User user1;
            if (user.isPresent()) {
                user1 = user.get();
                user1.setStatus(StatusEnum.DELETED);
                userRepository.save(user1);
                return new GetUserDto(user1.getName(), user1.getSurname(), user1.getPrenotations());
            } else {
                try {
                    throw new ResponseStatusNotFoundException("Secretary not found!");
                } catch (ResponseStatusNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

