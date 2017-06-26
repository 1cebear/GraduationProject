package ru.gradproject.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.model.Restaurant;
import ru.gradproject.topjava.repository.MenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
@Repository
@Transactional(readOnly = true)
public class JpaMenuRepository implements MenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Menu get(int id, int restaurantId) {
        Menu menu = em.find(Menu.class, id);
        return menu != null && menu.getRestaurant().getId() == restaurantId ? menu : null;
    }

    @Override
    @Transactional
    public Menu save(Menu menu, int restaurantId) {
        if (!menu.isNew() && get(menu.getId(), restaurantId) == null) {
            return null;
        }
        menu.setRestaurant(em.getReference(Restaurant.class, restaurantId));
        if (menu.isNew()) {
            em.persist(menu);
            return menu;
        } else {
            return em.merge(menu);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id, int restaurantId) {
        return em.createNamedQuery(Menu.DELETE, Menu.class).setParameter("id", id).setParameter("restaurant_id", restaurantId).executeUpdate() != 0;
    }

    @Override
    public List<Menu> getAll(int restaurantId) {
        return em.createNamedQuery(Menu.ALL_SORTED, Menu.class).setParameter("restaurant_id", restaurantId).getResultList();
    }
}
