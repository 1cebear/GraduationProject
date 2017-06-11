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
    static final String REST_URL = "/rest/dishes";

    @Override
    @GetMapping
    public List<Dish> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Dish get(int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(Dish dish, int id) {
        super.update(dish, id);
    }

    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish dish) {
        Dish created = super.create(dish);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}

