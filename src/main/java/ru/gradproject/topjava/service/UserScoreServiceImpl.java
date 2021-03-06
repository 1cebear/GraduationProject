package ru.gradproject.topjava.service;

import org.springframework.stereotype.Service;
import ru.gradproject.topjava.model.UserScore;
import ru.gradproject.topjava.repository.UserScoreRepository;
import ru.gradproject.topjava.util.exception.UserScoreTimeException;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
@Service
public class UserScoreServiceImpl implements UserScoreService {
    private final UserScoreRepository userScoreRepository;

    public UserScoreServiceImpl(UserScoreRepository userScoreRepository) {
        this.userScoreRepository = userScoreRepository;
    }

    @Override
    public UserScore get(int id, int userId, int menuId) {
        return userScoreRepository.get(id, userId, menuId);
    }

    @Override
    public UserScore save(UserScore userScore, int userid, int menuId) {
        return userScoreRepository.save(userScore, userid, menuId);
    }

    @Override
    public UserScore update(UserScore userScore, int userid, int menuId) {
        if(LocalTime.now().compareTo(LocalTime.of(11, 0, 0))>0)
        {
            throw new UserScoreTimeException("Vote can't be changed after 11:00");
        }
        return userScoreRepository.save(userScore, userid, menuId);
    }

    @Override
    public boolean delete(int id, int userId, int menuId) {
        return userScoreRepository.delete(id, userId, menuId);
    }

    @Override
    public List<UserScore> getAll(Integer userId, Integer menuId) {
        return userScoreRepository.getAll(userId, menuId);
    }
}
