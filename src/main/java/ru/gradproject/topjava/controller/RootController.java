package ru.gradproject.topjava.controller;

/**
 * Created by Icebear on 06.06.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gradproject.topjava.service.DishService;
import ru.gradproject.topjava.service.MenuService;


@Controller
public class RootController {

    @Autowired
    private DishService dishService;

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("dishes", dishService.getAll(100000));
        model.addAttribute("menus", menuService.getAll());
        return "main";
    }

}

