package com.dev.notesapp.dtos.controllers;
import com.dev.notesapp.dtos.UserDto;
import com.dev.notesapp.sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import  org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

@PostMapping("/register")
public List<String> addUser(@RequestBody UserDto userDta){
    String passHash = passwordEncoder.encode(userDta.getPassword());
    userDta.setPassword(passHash);
    return userService.addUser(userDta);


};

@PostMapping("/login")
public List<String> userLogin(@RequestBody UserDto userDto){
    return userService.userLogin(userDto);

}


}
