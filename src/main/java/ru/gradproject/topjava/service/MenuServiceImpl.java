package ru.gradproject.topjava.service;

import org.springframework.stereotype.Service;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.repository.MenuRepository;

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
    public Menu get(int id) {
        return menuRepository.get(id);
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public boolean delete(int id) {
        return menuRepository.delete(id);
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.getAll();
    }
}
