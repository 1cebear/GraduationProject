package ru.gradproject.topjava.service;

import ru.gradproject.topjava.model.UserScore;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
public interface UserScoreService {
    UserScore get(int id, int userId, int menuId);

    UserScore save(UserScore userScore, int userid, int menuId);

    UserScore update(UserScore userScore, int userid, int menuId);

    boolean delete(int id, int userId, int menuId);

    List<UserScore> getAll(Integer userId, Integer menuId);
}
