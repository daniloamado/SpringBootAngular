package com.example.demo.controller;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "role")
@CrossOrigin(origins = "http://localhost:4200")
@Log4j2
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Role registerRole(@RequestBody Role role) {

        log.info("Registering role: {}", role.getRoleName());
        return roleService.createOrUpdateRole(role);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Role> findAllRoles() {

        log.info("Finding all roles");
        return roleService.findAll();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        log.info("Updating role id: {}", id);
        return roleService.createOrUpdateRole(role);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id) throws RecordNotFoundException {
        log.info("Deleting role id: {}", id);
        roleService.deleteRoleById(id);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Role getRole(@PathVariable Long id) throws RecordNotFoundException {
        log.info("Getting role id: {}", id);
        return roleService.findRoleById(id);
    }
}
