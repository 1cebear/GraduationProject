package ru.gradproject.topjava.controller.userscore;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gradproject.topjava.ActiveMenu;
import ru.gradproject.topjava.ActiveUser;
import ru.gradproject.topjava.model.UserScore;
import ru.gradproject.topjava.service.UserScoreService;

import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
public abstract class AbstractUserScoreController {
    @Autowired
    private UserScoreService userScoreService;

    public List<UserScore> getAll() {
        int userId = ActiveUser.id();
        int menuId = ActiveMenu.id();
        return userScoreService.getAll(userId, menuId);
    }

    public List<UserScore> getAllByUserAndMenu(int userId, int menuId) {
        return userScoreService.getAll(userId, menuId);
    }

    public List<UserScore> getAllByUser(int userId) {
        return userScoreService.getAll(userId, null);
    }

    public List<UserScore> getAllByMenu(int menuId) {
        return userScoreService.getAll(null, menuId);
    }

    public UserScore get(int id) {
        return userScoreService.get(id, ActiveUser.id(), ActiveMenu.id());
    }

    public UserScore get(int id, int userId, int menuId) {
        return userScoreService.get(id, userId, menuId);
    }

    public void delete(int id) {
        userScoreService.delete(id, ActiveUser.id(), ActiveMenu.id());
    }

    public void delete(int id, int userId, int menuId) {
        userScoreService.delete(id, userId, menuId);
    }

    public void update(UserScore userScore, int id) {
        userScoreService.update(userScore, ActiveUser.id, ActiveMenu.id());
    }

    public UserScore create(UserScore userScore) {
        return userScoreService.save(userScore, ActiveUser.id, ActiveMenu.id());
    }

    public void update(UserScore userScore, int userId, int menuId, int id) {
        userScoreService.update(userScore, userId, menuId);
    }

    public UserScore create(UserScore userScore, int userId, int menuId) {
        return userScoreService.save(userScore, userId, menuId);
    }
}
