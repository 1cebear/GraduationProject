package ru.gradproject.topjava.controller.dish;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gradproject.topjava.ActiveMenu;
import ru.gradproject.topjava.model.Dish;
import ru.gradproject.topjava.service.DishService;

import java.util.List;

/**
 * Created by Icebear on 04.06.2017.
 */
public abstract class AbstractDishController {

    @Autowired
    private DishService dishService;

    public List<Dish> getAll() {
        int menuId = ActiveMenu.id();
        return dishService.getAll(menuId);
    }

    public Dish get(int id) {
        int menuId = ActiveMenu.id();
        return dishService.get(id, menuId);
    }

    public void delete(int id) {
        int menuId = ActiveMenu.id();
        dishService.delete(id, menuId);
    }

    public Dish create(Dish dish) {
        int menuId = ActiveMenu.id();
        return dishService.save(dish, menuId);
    }

    public void update(Dish dish, int id) {
        int menuId = ActiveMenu.id();
        dishService.update(dish, menuId);
    }

    public List<Dish> getAll(int menuId, int restaurantId) {
        return dishService.getAll(menuId);
    }

    public Dish get(int id, int menuId, int restaurantId) {
        return dishService.get(id, menuId);
    }

    public void delete(int id, int menuId, int restaurantId) {
        dishService.delete(id, menuId);
    }

    public Dish create(Dish dish, int menuId, int restaurantId) {
        return dishService.save(dish, menuId);
    }

    public void update(Dish dish, int id, int menuId, int restaurantId) {
        dishService.update(dish, menuId);
    }
}
