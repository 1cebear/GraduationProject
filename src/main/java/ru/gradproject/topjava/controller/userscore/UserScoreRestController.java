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
    @GetMapping("/{id}")
    public UserScore get(int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(UserScore userScore, int id) {
        super.update(userScore, id);
    }

    public ResponseEntity<UserScore> createWithLocation(@RequestBody UserScore userScore) {
        UserScore created = super.create(userScore);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
