package ru.gradproject.topjava.service;

import ru.gradproject.topjava.model.Dish;

import java.util.List;

/**
 * Created by Icebear on 04.06.2017.
 */
public interface DishService {
    Dish get(int id, int MenuId);

    Dish save(Dish dish, int MenuId);

    Dish update(Dish dish, int MenuId);

    boolean delete(int id, int MenuId);

    List<Dish> getAll(int MenuId);
}
