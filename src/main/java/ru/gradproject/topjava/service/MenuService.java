package ru.gradproject.topjava.service;

import ru.gradproject.topjava.model.Menu;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
public interface MenuService {
    Menu get(int id);

    Menu save(Menu menu);

    Menu update(Menu menu);

    boolean delete(int id);

    List<Menu> getAll();
}
