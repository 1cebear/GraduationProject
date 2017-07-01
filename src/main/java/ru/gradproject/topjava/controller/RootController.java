package ru.gradproject.topjava.controller;

/**
 * Created by Icebear on 06.06.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gradproject.topjava.ActiveMenu;
import ru.gradproject.topjava.ActiveRestaurant;
import ru.gradproject.topjava.ActiveUser;
import ru.gradproject.topjava.service.DishService;
import ru.gradproject.topjava.service.MenuService;


@Controller
public class RootController {

    @Autowired
    private DishService dishService;

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/")
    public String root() {
        return "redirect:main";
    }

    @GetMapping(value = "/index")
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String users(Model model) {
        ActiveUser.setId(100000);
        if (ActiveMenu.id() == 0) {
            ActiveMenu.setId(100004);
        }
        model.addAttribute("dishes", dishService.getAll(ActiveMenu.id()));
        model.addAttribute("menus", menuService.getAll(ActiveRestaurant.id()));
        return "main";
    }

}

