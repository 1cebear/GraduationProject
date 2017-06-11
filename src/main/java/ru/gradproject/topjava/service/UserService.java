package ru.gradproject.topjava.service;

import ru.gradproject.topjava.model.User;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
public interface UserService {
    User get(int id);

    User save(User user);

    User update(User user);

    boolean delete(int id);

    List<User> getAll();
}
