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
    static final String REST_URL = "/rest/menus/{menuId}/dishes";

    @Override
    @GetMapping("")
    public List<Dish> getAll(@PathVariable("menuId") int menuId) {
        return super.getAll(menuId);
    }

    @Override
    @GetMapping("/{id}")
    public Dish get(@PathVariable("menuId") int menuId, @PathVariable("id") int id) {
        return super.get(id, menuId);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("menuId") int menuId, @PathVariable("id") int id) {
        super.delete(id, menuId);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Dish dish,@PathVariable("menuId") int menuId, @PathVariable("id")  int id) {
        super.update(dish, id, menuId);
    }

    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish dish) {
        Dish created = super.create(dish);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}

