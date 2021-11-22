package com.mldc.mldcBack.repository;

import java.util.List;
import java.util.Optional;

import com.mldc.mldcBack.Model.Menu;
import com.mldc.mldcBack.interfaces.MenuProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepo extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m ORDER BY lastUpdate DESC")
    List<MenuProjection> getAllMenus();

    Optional<Menu>findById(Long id);
}
