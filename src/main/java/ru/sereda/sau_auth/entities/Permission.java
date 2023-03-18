package ru.sereda.sau_auth.entities;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Permission {
    private final Set<String> possibilities = new TreeSet<>();
    private final Set<String> menus= new TreeSet<>();

    public void addPossibilities(List<String> possibilities){
        this.possibilities.addAll(possibilities);
    }
    public void addMenus(List<String> menus){
        this.menus.addAll(menus);
    }

    public Set<String> getPossibilities() {
        return possibilities;
    }

    public Set<String> getMenus() {
        return menus;
    }
}
