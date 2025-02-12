package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Optional;

public interface RoleDao {
    Optional<Role> getRoleByName(String name);
}
