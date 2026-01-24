package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Log4j2
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createOrUpdateRole(Role entity) {

        log.info("Creating or updating role");
        if (entity.getId() == null) {
            entity = roleRepository.save(entity);
            return entity;
        } else {
            Optional<Role> role = roleRepository.findById(entity.getId());
            if (role.isPresent()) {
                Role newRole = role.get();
                newRole.setRoleName(entity.getRoleName());
                roleRepository.save(newRole);
                return newRole;
            } else {
                entity = roleRepository.save(entity);
                return entity;
            }
        }
    }

    public List<Role> findAll() {
        log.info("Finding all roles");
        return (List<Role>) roleRepository.findAll();
    }

    public Role findRoleById(Long id) throws RecordNotFoundException {
        log.info("Finding role by id: {}", id);
        Optional<Role> role = roleRepository.findById(id);

        if (role.isPresent()) {
            return role.get();
        } else {
            throw new RecordNotFoundException("No role record exists for given id");
        }
    }

    public void deleteRoleById(Long id) throws RecordNotFoundException {
        log.info("Deleting role by id: {}", id);
        Optional<Role> role = roleRepository.findById(id);

        if (role.isPresent()) {
            roleRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No role record exists for given id");
        }
    }

}