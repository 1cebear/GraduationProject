package ru.gradproject.topjava.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Icebear on 04.06.2017.
 */
public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
