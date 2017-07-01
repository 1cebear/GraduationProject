package ru.gradproject.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.model.User;
import ru.gradproject.topjava.model.UserScore;
import ru.gradproject.topjava.repository.UserScoreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
@Repository
@Transactional(readOnly = true)
public class JpaUserScoreRepository implements UserScoreRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserScore get(int id, int userId, int menuId) {
        UserScore userScore = em.find(UserScore.class, id);
        return userScore != null && userScore.getMenu().getId() == menuId && userScore.getUser().getId() == userId ? userScore : null;
    }

    @Override
    public UserScore save(UserScore userScore, int userid, int menuId) {
        if (!userScore.isNew() && get(userScore.getId(), userid, menuId) == null) {
            return null;
        }
        userScore.setMenu(em.getReference(Menu.class, menuId));
        userScore.setUser(em.getReference(User.class, userid));
        if (userScore.isNew()) {
            em.persist(userScore);
            return userScore;
        } else {
            return em.merge(userScore);
        }
    }

    @Override
    public boolean delete(int id, int userId, int menuId) {
        return em.createNamedQuery(UserScore.DELETE).setParameter("menuId", menuId).setParameter("userId", userId).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public List<UserScore> getAll(Integer userId, Integer menuId) {
        if (userId == null) {
            return em.createNamedQuery(UserScore.ALL_BY_MENU, UserScore.class).setParameter("menuId", menuId).getResultList();
        } else if (menuId == null) {
            return em.createNamedQuery(UserScore.All_BY_USER, UserScore.class).setParameter("userId", userId).getResultList();
        } else {
            return em.createNamedQuery(UserScore.ALL_SORTED, UserScore.class).setParameter("menuId", menuId).setParameter("userId", userId).getResultList();
        }
    }
}
