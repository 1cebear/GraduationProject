package ru.gradproject.topjava.controller.dish;

import ru.gradproject.topjava.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gradproject.topjava.service.DishService;

import java.util.List;

/**
 * Created by Icebear on 04.06.2017.
 */
public abstract class AbstractDishController {

    @Autowired
    private DishService dishService;

    public List<Dish> getAll() {
        int menuId = 100000;
        return dishService.getAll(menuId);
    }

    public Dish get(int id) {
        int menuId = 100000;
        return dishService.get(id, menuId);
    }

    public void delete(int id) {
        int menuId = 100000;
        dishService.delete(id, menuId);
    }

    public Dish create(Dish dish) {
        int menuId = 100000;
        return dishService.save(dish, menuId);
    }

    public void update(Dish dish, int id) {
        int menuId = 100000;
        dishService.update(dish, menuId);
    }
}
