package com.example.demo.controller;

import com.example.demo.dto.user.AddUserDto;
import com.example.demo.dto.user.GetUserDto;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.service.UserService;
import jakarta.mvc.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
@PostMapping("/salva")
public AddUserDto addUserDto(@RequestBody AddUserDto addUserDto){return userService.addUser(addUserDto);}
    @GetMapping("/list")
public List<GetUserDto> usersFindAll(){return userService.findAll();}
    @GetMapping("/{name}")
    public GetUserDto getUserDto(@PathVariable Long id) throws ResponseStatusNotFoundException {
        return userService.findById(id);
    }

    @PutMapping ("/{id}")
    public AddUserDto updateUser(@PathVariable Long id, @RequestBody AddUserDto addUserDto){
        return userService.updateUser(id,addUserDto);
    }

    @DeleteMapping("/delite/{id}")
    public GetUserDto logicaldelite(@PathVariable Long id){
        return userService.logicalDeleteSecretaryById(id);
    }

@DeleteMapping("/Delite/{id}")
    public ResponseEntity<?> physicalDelite(@PathVariable Long id) {userService.physicalDeliteById(id);
    return ResponseEntity.ok("delited");}
}
