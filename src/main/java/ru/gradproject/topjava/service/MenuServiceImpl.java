package ru.gradproject.topjava.service;

import org.springframework.stereotype.Service;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.repository.MenuRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu get(int id, int restaurantId) {
        return menuRepository.get(id, restaurantId);
    }

    @Override
    public Menu save(Menu menu, int restaurantId) {
        if (menu.isNew()) {
            menu.setMenuDate(LocalDateTime.now());
        }
        return menuRepository.save(menu, restaurantId);
    }

    @Override
    public Menu update(Menu menu, int restaurantId) {
        return menuRepository.save(menu, restaurantId);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return menuRepository.delete(id, restaurantId);
    }

    @Override
    public List<Menu> getAll(int restaurantId) {
        return menuRepository.getAll(restaurantId);
    }
}
