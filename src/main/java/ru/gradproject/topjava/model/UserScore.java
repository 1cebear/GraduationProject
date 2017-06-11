package ru.gradproject.topjava.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Icebear on 05.06.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = UserScore.ALL_SORTED, query = "SELECT us FROM UserScore us WHERE us.menu.id=:menuId AND us.user.id=:userId"),
        @NamedQuery(name = UserScore.DELETE, query = "DELETE FROM UserScore us WHERE us.id=:id AND us.menu.id=:menuId AND us.user.id=:userId")
})
@Entity
@Table(name = "userscores")
public class UserScore extends BaseEntity {

    public static final String ALL_SORTED = "UserScore.getAll";
    public static final String DELETE = "UserScore.delete";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    @Column(name = "score")
    @NotNull
    private int score;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
