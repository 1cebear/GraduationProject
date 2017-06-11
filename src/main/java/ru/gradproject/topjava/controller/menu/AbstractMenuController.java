package ru.gradproject.topjava.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
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
        return menuService.getAll();
    }

    public Menu get(int id) {
        return menuService.get(id);
    }

    public void delete(int id) {
        menuService.delete(id);
    }

    public Menu create(Menu Menu) {
        return menuService.save(Menu);
    }

    public void update(Menu Menu, int id) {
        menuService.update(Menu);
    }
}
