package ru.gradproject.topjava.service;

import org.springframework.stereotype.Service;
import ru.gradproject.topjava.model.Restaurant;
import ru.gradproject.topjava.repository.RestaurantRepository;

import java.util.List;

/**
 * Created by Icebear on 25.06.2017.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant get(int id) {
        return restaurantRepository.get(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return restaurantRepository.delete(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }
}
