package ru.gradproject.topjava.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gradproject.topjava.model.User;
import ru.gradproject.topjava.service.UserService;

import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
public abstract class AbstractUserController {
    @Autowired
    private UserService userService;

    public List<User> getAll() {
        return userService.getAll();
    }

    public User get(int id) {
        return userService.get(id);
    }

    public void delete(int id) {
        userService.delete(id);
    }

    public User create(User user) {
        return userService.save(user);
    }

    public void update(User user, int id) {
        userService.update(user);
    }
}
