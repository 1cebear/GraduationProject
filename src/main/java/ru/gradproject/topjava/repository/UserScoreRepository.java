package ru.gradproject.topjava.repository;

import ru.gradproject.topjava.model.UserScore;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
public interface UserScoreRepository {
    UserScore get(int id, int userId, int menuId);

    UserScore save(UserScore userScore, int userid, int menuId);

    boolean delete(int id, int userId, int menuId);

    List<UserScore> getAll(int userId, int menuId);
}
