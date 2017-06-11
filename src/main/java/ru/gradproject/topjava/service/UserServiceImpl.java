package ru.gradproject.topjava.service;

import org.springframework.stereotype.Service;
import ru.gradproject.topjava.model.User;
import ru.gradproject.topjava.repository.UserRepository;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}
