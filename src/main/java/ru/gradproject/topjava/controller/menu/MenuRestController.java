package ru.gradproject.topjava.controller.menu;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.gradproject.topjava.controller.dish.DishRestController;
import ru.gradproject.topjava.model.Menu;

import java.net.URI;
import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
@RestController
@RequestMapping(value = MenuRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController extends AbstractMenuController {
    static final String REST_URL = "/rest/restaurants/{restaurantId}/menus";

    @Override
    @GetMapping
    public List<Menu> getAll(@PathVariable("restaurantId") int restaurantId) {
        return super.getAll(restaurantId);
    }

    @Override
    @GetMapping("/{id}")
    public Menu get(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        return super.get(id, restaurantId);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        super.delete(id, restaurantId);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Menu menu, @PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        super.update(menu, restaurantId, id);
    }

    public ResponseEntity<Menu> createWithLocation(@RequestBody Menu menu) {
        Menu created = super.create(menu);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
