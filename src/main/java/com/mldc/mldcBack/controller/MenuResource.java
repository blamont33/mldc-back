package com.mldc.mldcBack.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.mldc.mldcBack.Model.Menu;
import com.mldc.mldcBack.Model.Recipe;
import com.mldc.mldcBack.interfaces.MenuProjection;
import com.mldc.mldcBack.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuResource {
    private final MenuService menuService;

    @Autowired
    public MenuResource(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/add")
    public ResponseEntity<Menu> addMenu(@RequestParam Set<Recipe> recipes) {
        Menu menu = menuService.addMenu(recipes);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MenuProjection>> getAllMenus() {
        List<MenuProjection> menus = menuService.getAllMenus();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Menu>> getMenuById(@PathVariable("id") Long id) {
        Optional<Menu> menu = menuService.getMenuById(id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

}
