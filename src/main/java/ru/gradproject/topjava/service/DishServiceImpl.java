package ru.gradproject.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gradproject.topjava.model.Dish;
import ru.gradproject.topjava.repository.DishRepository;

import java.util.List;

/**
 * Created by Icebear on 04.06.2017.
 */
@Service
public class DishServiceImpl implements DishService {

    private final DishRepository repository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dish get(int id, int menuId) {
        return repository.get(id, menuId);
    }

    @Override
    public Dish save(Dish dish, int menuId) {
        return repository.save(dish, menuId);
    }

    @Override
    public Dish update(Dish dish, int menuId) {
        return repository.save(dish, menuId);
    }

    @Override
    public boolean delete(int id, int menuId) {
        return repository.delete(id, menuId);
    }

    @Override
    public List<Dish> getAll(int menuId) {
        return repository.getAll(menuId);
    }
}
