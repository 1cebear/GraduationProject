package ru.gradproject.topjava.service;

import ru.gradproject.topjava.model.Menu;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
public interface MenuService {
    Menu get(int id, int restaurantId);

    Menu save(Menu menu, int restaurantId);

    Menu update(Menu menu, int restaurantId);

    boolean delete(int id, int restaurantId);

    List<Menu> getAll(int restaurantId);
}
