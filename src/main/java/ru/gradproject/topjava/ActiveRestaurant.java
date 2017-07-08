package ru.gradproject.topjava;

import ru.gradproject.topjava.model.BaseEntity;

/**
 * Created by Icebear on 25.06.2017.
 */
public class ActiveRestaurant {
    public static int id = BaseEntity.START_SEQ + 2;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        ActiveRestaurant.id = id;
    }
}
