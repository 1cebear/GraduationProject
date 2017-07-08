package ru.gradproject.topjava.controller.dish;

import ru.gradproject.topjava.model.Dish;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


/**
 * Created by Icebear on 06.06.2017.
 */
@RestController
@RequestMapping(value = DishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController extends AbstractDishController {
    static final String REST_URL = "/rest/restaurants/{restaurantId}/menus/{menuId}/dishes";

    @Override
    @GetMapping("")
    public List<Dish> getAll(@PathVariable("restaurantId") int restaurantId, @PathVariable("menuId") int menuId) {
        return super.getAll(menuId, restaurantId);
    }

    @Override
    @GetMapping("/{id}")
    public Dish get(@PathVariable("restaurantId") int restaurantId, @PathVariable("menuId") int menuId, @PathVariable("id") int id) {
        return super.get(id, menuId, restaurantId);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("restaurantId") int restaurantId, @PathVariable("menuId") int menuId, @PathVariable("id") int id) {
        super.delete(id, menuId, restaurantId);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Dish dish, @PathVariable("restaurantId") int restaurantId, @PathVariable("menuId") int menuId, @PathVariable("id") int id) {
        super.update(dish, id, menuId, restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish dish, @PathVariable("restaurantId") int restaurantId, @PathVariable("menuId") int menuId) {
        Dish created = super.create(dish, restaurantId, menuId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(restaurantId, menuId, created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}

