package ru.gradproject.topjava.repository;

import ru.gradproject.topjava.model.User;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
public interface UserRepository {
    User get(int id);

    User save(User user);

    boolean delete(int id);

    List<User> getAll();
}
