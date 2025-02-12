package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void update(User user);
    void delete(User user);
    Optional<User> findByName(String username);
}
