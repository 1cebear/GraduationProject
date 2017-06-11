package ru.gradproject.topjava.controller.userscore;

import org.springframework.beans.factory.annotation.Autowired;
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
        int userId = 100000;
        int menuId = 100000;
        return userScoreService.getAll(userId, menuId);
    }

    public UserScore get(int id) {
        int userId = 100000;
        int menuId = 100000;
        return userScoreService.get(id, userId, menuId);
    }

    public void delete(int id) {
        int userId = 100000;
        int menuId = 100000;
        userScoreService.delete(id, userId, menuId);
    }

    public UserScore create(UserScore userScore) {
        int userId = 100000;
        int menuId = 100000;
        return userScoreService.save(userScore,userId, menuId);
    }

    public void update(UserScore userScore, int id) {
        int userId = 100000;
        int menuId = 100000;
        userScoreService.update(userScore, userId, menuId);
    }
}
