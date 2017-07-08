package ru.gradproject.topjava.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;
import ru.gradproject.topjava.ActiveMenu;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Icebear on 04.06.2017.
 */
@NamedQueries({
        @NamedQuery(name = Menu.ALL_SORTED, query = "SELECT m FROM Menu m where m.restaurant.id=:restaurant_id"),
        @NamedQuery(name = Menu.DELETE, query = "DELETE FROM Menu m WHERE m.id=:id AND m.restaurant.id=:restaurant_id")
})
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {

    public static final String DELETE = "Menu.delete";
    public static final String ALL_SORTED = "Menu.getAll";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @JsonManagedReference
    private Set<Dish> dishes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private Restaurant restaurant;

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime menuDate;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
//    @JsonManagedReference
//    private Set<UserScore> userScores;
//
//    public Set<UserScore> getUserScores() {
//        return userScores;
//    }
//
//    public void setUserScores(Set<UserScore> userScores) {
//        this.userScores = userScores;
//    }

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

    public boolean isActive() {
        return (getId() == ActiveMenu.id());
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Menu(String name)
    {
        super();
        this.name = name;
    }

    public Menu()
    {
        super();
    }

    public Menu(Integer id, String name, Restaurant restaurant, LocalDateTime localDateTime)
    {
        super(id);
        this.name = name;
        this.restaurant = restaurant;
        this.menuDate = localDateTime;
    }


}
