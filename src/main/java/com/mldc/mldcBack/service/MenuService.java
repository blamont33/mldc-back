package com.mldc.mldcBack.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.mldc.mldcBack.Model.Menu;
import com.mldc.mldcBack.Model.Recipe;
import com.mldc.mldcBack.interfaces.MenuProjection;
import com.mldc.mldcBack.repository.MenuRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private final MenuRepo menuRepo;

    @Autowired
    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    // Create a new menu
    public Menu addMenu(Set<Recipe> recipes) {
        Menu menu = new Menu(recipes);
        return menuRepo.save(menu);
    }

    // Get all menus
    public List<MenuProjection> getAllMenus() {
        return menuRepo.getAllMenus();

    }

    // Get menu by Id
    public Optional<Menu> getMenuById(Long id) {
        Optional<Menu> menu = menuRepo.findById(id);
        if (menu.isPresent()) {
            return menuRepo.findById(id);
        } else {
            throw new IllegalStateException("The menu with id " + id + " doesn't exists");
        }

    }

}
