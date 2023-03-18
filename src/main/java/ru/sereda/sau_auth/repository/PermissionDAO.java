package ru.sereda.sau_auth.repository;

import org.springframework.stereotype.Repository;
import ru.sereda.sau_auth.security.Role;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PermissionDAO {
    public List<String> getPossibilities(Role role) {
        List<String> possibilities = new ArrayList<>();
        switch (role) {
            case ADMIN -> {
                possibilities.add("ADMIN_POSSIBILITY_1");
                possibilities.add("ADMIN_POSSIBILITY_2");
                possibilities.add("OPERATOR_POSSIBILITY_1");
                possibilities.add("OPERATOR_POSSIBILITY_2");
                possibilities.add("OBSERVER_POSSIBILITY_1");
                possibilities.add("OBSERVER_POSSIBILITY_2");
            }
            case OPERATOR -> {
                possibilities.add("OPERATOR_POSSIBILITY_1");
                possibilities.add("OPERATOR_POSSIBILITY_2");
                possibilities.add("OBSERVER_POSSIBILITY_1");
                possibilities.add("OBSERVER_POSSIBILITY_2");
            }
            case OBSERVER -> {
                possibilities.add("OBSERVER_POSSIBILITY_1");
                possibilities.add("OBSERVER_POSSIBILITY_2");
            }
            default -> {

            }
        }
        return possibilities;
    }

    public List<String> getMenus(Role role) {
        List<String> menus = new ArrayList<>();
        switch (role) {
            case ADMIN -> {
                menus.add("ADMIN_MENU_1");
                menus.add("ADMIN_MENU_2");
                menus.add("OPERATOR_MENU_1");
                menus.add("OPERATOR_MENU_2");
                menus.add("OBSERVER_MENU_1");
                menus.add("OBSERVER_MENU_2");
            }
            case OPERATOR -> {
                menus.add("OPERATOR_MENU_1");
                menus.add("OPERATOR_MENU_2");
                menus.add("OBSERVER_MENU_1");
                menus.add("OBSERVER_MENU_2");
            }
            case OBSERVER -> {
                menus.add("OBSERVER_MENU_1");
                menus.add("OBSERVER_MENU_2");
            }
            default -> {

            }
        }
        return menus;
    }
}
