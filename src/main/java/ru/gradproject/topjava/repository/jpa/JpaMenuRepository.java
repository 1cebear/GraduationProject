package ru.gradproject.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.repository.MenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
@Repository
@Transactional(readOnly = true)
public class JpaMenuRepository implements MenuRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Menu get(int id) {
        Menu menu = em.find(Menu.class, id);
        return menu != null ? menu : null;
    }

    @Override
    @Transactional
    public Menu save(Menu menu) {
        if (!menu.isNew()) {
            return null;
        }
        if (menu.isNew()) {
            em.persist(menu);
            return menu;
        } else {
            return em.merge(menu);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Menu.DELETE, Menu.class).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public List<Menu> getAll() {
        return em.createNamedQuery(Menu.ALL_SORTED, Menu.class).getResultList();
    }
}
