package ru.gradproject.topjava.repository;

import ru.gradproject.topjava.model.Menu;

import java.util.List;

/**
 * Created by Icebear on 05.06.2017.
 */
public interface MenuRepository {
    Menu get(int id);

    Menu save(Menu menu);

    boolean delete(int id);

    List<Menu> getAll();
}
