package ru.sereda.sau_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sereda.sau_auth.entities.Permission;
import ru.sereda.sau_auth.security.Role;
import ru.sereda.sau_auth.service.PermissionService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/permissions")
public class PermissionsController {
    @Autowired
    PermissionService permissionService;
    @PostMapping("/permissions")
    public Permission getPermissions(@RequestBody List<Role> roles){
        return permissionService.getPermission(roles);
    }
}
