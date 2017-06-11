package ru.gradproject.topjava.repository;

import ru.gradproject.topjava.model.Dish;

import java.util.List;

/**
 * Created by Icebear on 04.06.2017.
 */
public interface DishRepository {
    Dish get(int id, int MenuId);

    Dish save(Dish dish, int menuId);

    boolean delete(int id, int MenuId);

    List<Dish> getAll(int MenuId);
}
