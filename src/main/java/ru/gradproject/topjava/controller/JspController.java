package ru.gradproject.topjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gradproject.topjava.ActiveMenu;
import ru.gradproject.topjava.ActiveRestaurant;
import ru.gradproject.topjava.service.DishService;
import ru.gradproject.topjava.service.MenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by Icebear on 12.06.2017.
 */
@Controller
@RequestMapping(value = "/main")
public class JspController {

    @Autowired
    private DishService dishService;

    @Autowired
    private MenuService menuService;

    @GetMapping("selectMenu")
    public String selectMenu(HttpServletRequest request, Model model)
    {
        ActiveMenu.setId(getId(request));
        model.addAttribute("dishes", dishService.getAll(ActiveMenu.id()));
        model.addAttribute("menus", menuService.getAll(ActiveRestaurant.id()));
        return "redirect:/main";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
