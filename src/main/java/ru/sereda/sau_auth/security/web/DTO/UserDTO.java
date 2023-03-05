package ru.sereda.sau_auth.security.web.DTO;

import ru.sereda.sau_auth.security.Role;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String login;
    private List<String> roles;

    public UserDTO(String login, List<String> roles) {
        this.login = login;
        this.roles = roles;
    }

    public UserDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Role> getRoles() {//TODO Role generator
        List<Role> roleList = new ArrayList<>();
        for (String roleString : roles){
            if (roleString.equals("ADMIN"))
                roleList.add(Role.ADMIN);
            if (roleString.equals("OBSERVER"))
                roleList.add(Role.OBSERVER);
            if (roleString.equals("OPERATOR"))
                roleList.add(Role.OPERATOR);
        }
        return roleList;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
