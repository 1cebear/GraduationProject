package ru.gradproject.topjava.repository;

import ru.gradproject.topjava.model.Restaurant;

import java.util.List;

/**
 * Created by Icebear on 25.06.2017.
 */
public interface RestaurantRepository {
    Restaurant get(int id);

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    List<Restaurant> getAll();
}
