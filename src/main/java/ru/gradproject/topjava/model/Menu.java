package ru.gradproject.topjava.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Icebear on 04.06.2017.
 */
@NamedQueries({
        @NamedQuery(name = Menu.ALL_SORTED, query = "SELECT m FROM Menu m"),
        @NamedQuery(name = Menu.DELETE, query = "DELETE FROM Menu m WHERE m.id=:id")
})
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {

    public static final String DELETE = "Menu.delete";
    public static final String ALL_SORTED = "Menu.getAll";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private Set<Dish> dishes;


    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime menuDate;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private Set<UserScore> userScores;

    public Set<UserScore> getUserScores() {
        return userScores;
    }

    public void setUserScores(Set<UserScore> userScores) {
        this.userScores = userScores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public LocalDateTime getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(LocalDateTime menuDate) {
        this.menuDate = menuDate;
    }
}
