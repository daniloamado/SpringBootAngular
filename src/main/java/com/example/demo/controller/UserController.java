package com.example.demo.controller;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
@CrossOrigin(origins = "http://localhost:4200")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User registerUser(@Valid @RequestBody User user) {

        log.info("registering user: {} ", user.getUsername());

        return userService.createOrUpdateUser(user);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> findAllUser() {

        log.info("finding all users");
        return userService.findAll();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public User updateUser(@PathVariable Long id, @RequestBody User user) {

        log.info("Updating user id: {}", id);
        return userService.createOrUpdateUser(user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) throws RecordNotFoundException {

        log.info("Deleting user id: {}", id);
        userService.deleteUserById(id);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public User getUser(@PathVariable Long id) throws RecordNotFoundException {
        log.info("getting user id: {}", id);
        return userService.findUserById(id);
    }

}
