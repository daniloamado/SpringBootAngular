package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
@CrossOrigin(origins = "http://localhost:4200")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User registerUser(@Valid @RequestBody User user) {

        log.info("registering user: {} ", user.getUsername());

        // TODO: userService.insert(user);
        return user;
    }
}
