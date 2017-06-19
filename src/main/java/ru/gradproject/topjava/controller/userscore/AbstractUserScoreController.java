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

    public UserScore get(int id) {
        int userId = ActiveUser.id();
        int menuId = ActiveMenu.id();
        return userScoreService.get(id, userId, menuId);
    }

    public void delete(int id) {
        int userId = ActiveUser.id();
        int menuId = ActiveMenu.id();
        userScoreService.delete(id, userId, menuId);
    }

    public UserScore create(UserScore userScore) {
        int userId = ActiveUser.id();
        int menuId = ActiveMenu.id();
        return userScoreService.save(userScore,userId, menuId);
    }

    public void update(UserScore userScore, int id) {
        int userId = ActiveUser.id();
        int menuId = ActiveMenu.id();
        userScoreService.update(userScore, userId, menuId);
    }

    public List<UserScore> getAll(Integer menuId, Integer userId) {
        return userScoreService.getAll(userId, menuId);
    }
}
