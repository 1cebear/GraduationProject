package ru.gradproject.topjava.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gradproject.topjava.model.Restaurant;
import ru.gradproject.topjava.service.RestaurantService;

import java.util.List;

/**
 * Created by Icebear on 25.06.2017.
 */
public abstract class AbstractRestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    public Restaurant get(int id) {
        return restaurantService.get(id);
    }

    public void delete(int id) {
        restaurantService.delete(id);
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    public void update(Restaurant Menu, int id) {
        restaurantService.update(Menu);
    }
}
