package ru.gradproject.topjava.controller.userscore;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.gradproject.topjava.model.UserScore;

import java.net.URI;
import java.util.List;

/**
 * Created by Icebear on 10.06.2017.
 */
@RestController
@RequestMapping(value = UserScoreRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserScoreRestController extends AbstractUserScoreController {

    static final String REST_URL = "/rest/userscores";

    @Override
    @GetMapping
    public List<UserScore> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/user/{userid}/menu/{menuid}")
    public List<UserScore> getAllByUserAndMenu(@PathVariable("userid") int userId, @PathVariable("menuid") int menuId) {
        return super.getAllByUserAndMenu(userId, menuId);
    }


    @Override
    @GetMapping("/user/{userid}")
    public List<UserScore> getAllByUser(@PathVariable("userid") int userId) {
        return super.getAllByUser(userId);
    }

    @Override
    @GetMapping("/menu/{menuid}")
    public List<UserScore> getAllByMenu(@PathVariable("menuid") int menuId) {
        return super.getAllByMenu(menuId);
    }

    @Override
    @GetMapping("/user/{userid}/menu/{menuid}/{id}")
    public UserScore get(@PathVariable("id") int id, @PathVariable("userid") int userId, @PathVariable("menuid") int menuId) {
        return super.get(id, userId, menuId);
    }

    @Override
    @DeleteMapping("/user/{userid}/menu/{menuid}/{id}")
    public void delete(@PathVariable("id") int id, @PathVariable("userid") int userId, @PathVariable("menuid") int menuId) {
        super.delete(id, userId, menuId);
    }

    @Override
    @PutMapping(value = "/user/{userid}/menu/{menuid}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserScore userScore, @PathVariable("userid") int userId, @PathVariable("menuid") int menuId, @PathVariable("id") int id) {
        super.update(userScore, userId, menuId, id);
    }

    @PostMapping(value = "/user/{userid}/menu/{menuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserScore> createWithLocation(@RequestBody UserScore userScore, @PathVariable("userid") int userId, @PathVariable("menuid") int menuId) {
        UserScore created = super.create(userScore, userId, menuId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(userId, menuId, created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
