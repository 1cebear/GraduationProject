package ru.gradproject.topjava;

import ru.gradproject.topjava.model.BaseEntity;

/**
 * Created by Icebear on 12.06.2017.
 */
public class ActiveMenu {
    public static int id = BaseEntity.START_SEQ + 4;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        ActiveMenu.id = id;
    }
}
