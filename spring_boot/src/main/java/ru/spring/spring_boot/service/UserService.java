package ru.spring.spring_boot.service;


import ru.spring.spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getlistUsers();

    void add(User user);

    void update(User user);

    void delete(Long id);

    User showId(Long id);
}
