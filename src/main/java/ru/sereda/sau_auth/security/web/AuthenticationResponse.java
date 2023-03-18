package ru.sereda.sau_auth.security.web;

import ru.sereda.sau_auth.entities.Permission;
import ru.sereda.sau_auth.security.Role;

import java.util.List;

public class AuthenticationResponse {

    private final String token;
    private final List<Role> roles;
    private final Permission permission;

    public List<Role> getRoles() {
        return roles;
    }

    public AuthenticationResponse(String token, List<Role> roles, Permission permission) {
        this.token = token;
        this.roles = roles;
        this.permission = permission;
    }

    public String getToken() {
        return token;
    }

    public Permission getPermission() {
        return permission;
    }
}
