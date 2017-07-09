package ru.gradproject.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gradproject.topjava.model.Dish;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.repository.DishRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Icebear on 06.06.2017.
 */
@Repository
@Transactional(readOnly = true)
public class JpaDishRepository implements DishRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Dish get(int id, int menuId) {
        Dish dish = em.find(Dish.class, id);
        return dish != null && dish.getMenu().getId() == menuId ? dish : null;
    }

    @Override
    @Transactional
    public Dish save(Dish dish, int menuId) {
        if (!dish.isNew() && get(dish.getId(), menuId) == null) {
            return null;
        }
        dish.setMenu(em.find(Menu.class, menuId));
        if (dish.isNew()) {
            em.persist(dish);
            return dish;
        } else {
            return em.merge(dish);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id, int menuId) {
        return em.createNamedQuery(Dish.DELETE).setParameter("menuId", menuId).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public List<Dish> getAll(int menuId) {
        return em.createNamedQuery(Dish.ALL_SORTED, Dish.class).setParameter("menuId", menuId).getResultList();
    }
}
