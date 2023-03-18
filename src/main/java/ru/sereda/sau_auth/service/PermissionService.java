package ru.sereda.sau_auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sereda.sau_auth.entities.Permission;
import ru.sereda.sau_auth.repository.PermissionDAO;
import ru.sereda.sau_auth.security.Role;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionDAO permissionDAO;

    public Permission getPermission(List<Role> roles) {
        Permission permission = new Permission();
        for (Role role : roles){
            permission.addPossibilities(permissionDAO.getPossibilities(role));
            permission.addMenus(permissionDAO.getMenus(role));
        }
        return permission;
    }
}
