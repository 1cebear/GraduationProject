package ru.gradproject.topjava.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gradproject.topjava.ActiveRestaurant;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.service.MenuService;

import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
public abstract class AbstractMenuController {

    @Autowired
    private MenuService menuService;

    public List<Menu> getAll() {
        int restaurantId = ActiveRestaurant.id();
        return menuService.getAll(restaurantId);
    }

    public Menu get(int id) {
        int restaurantId = ActiveRestaurant.id();
        return menuService.get(id, restaurantId);
    }

    public void delete(int id) {
        int restaurantId = ActiveRestaurant.id();
        menuService.delete(id, restaurantId);
    }

    public Menu create(Menu menu) {
        int restaurantId = ActiveRestaurant.id();
        return menuService.save(menu, restaurantId);
    }

    public void update(Menu Menu, int id) {
        int restaurantId = ActiveRestaurant.id();
        menuService.update(Menu, restaurantId);
    }

    public List<Menu> getAll(int restaurantId) {
        return menuService.getAll(restaurantId);
    }

    public Menu get(int id, int restaurantId) {
        return menuService.get(id, restaurantId);
    }

    public void delete(int id, int restaurantId) {
        menuService.delete(id, restaurantId);
    }

    public Menu create(Menu menu, int restaurantId) {
        return menuService.save(menu, restaurantId);
    }

    public void update(Menu menu, int id, int restaurantId) {
        menuService.update(menu, restaurantId);
    }
}
