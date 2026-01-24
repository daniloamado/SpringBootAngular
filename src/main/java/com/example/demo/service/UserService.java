package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Log4j2
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createOrUpdateUser(User entity) {

        log.info("Creating or updating user");
        if (entity.getId() == null) {
            entity = repository.save(entity);

            return entity;
        } else {

            Optional<User> user = repository.findById(entity.getId());

            if (user.isPresent()) {

                User newUser = user.get();
                newUser.setFirstName(entity.getFirstName());
                newUser.setLastName(entity.getLastName());
                newUser.setPassword(entity.getPassword());
                newUser.setUsername(entity.getUsername());

                repository.save(newUser);
                return newUser;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public List<User> findAll() {

        log.info("Finding all users");
        return (List<User>) repository.findAll();
    }

    public User findUserById(Long id) throws RecordNotFoundException {

        log.info("Finding user by id: {}", id);
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exists for given id");
        }

    }

    public void deleteUserById(Long id) throws RecordNotFoundException {

        log.info("Deleting user by id: {}", id);
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exists for given id");
        }
    }
}
