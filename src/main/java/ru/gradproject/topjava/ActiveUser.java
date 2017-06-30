package ru.gradproject.topjava;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.gradproject.topjava.model.BaseEntity;
import ru.gradproject.topjava.model.User;

import static java.util.Objects.requireNonNull;

/**
 * Created by Icebear on 12.06.2017.
 */
public class ActiveUser extends org.springframework.security.core.userdetails.User{
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        ActiveUser.id = id;
    }

    public ActiveUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRoles());
    }

    public static ActiveUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof ActiveUser) ? (ActiveUser) principal : null;
    }

    public static ActiveUser get() {
        ActiveUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }
}
