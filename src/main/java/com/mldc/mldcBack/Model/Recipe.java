package com.mldc.mldcBack.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String link;

    @Column(nullable = false)
    private int nbParts;

    @Lob
    private String making;

    @Column(nullable = true)
    private int calorie;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    Set<RecipeIngredient> recipeIngredients;

    @ManyToMany(mappedBy = "recipes", cascade = CascadeType.ALL)
    Set<Menu> menus;

    public Recipe() {
    }

    public Recipe(String name, String link, int nbParts, String making, int calorie) {
        this.name = name;
        this.link = link;
        this.nbParts = nbParts;
        this.making = making;
        this.calorie = calorie;
    }

    public Recipe(String name, String link, int nbParts, String making, int calorie,
            Set<RecipeIngredient> recipeIngredients, Set<Menu> menus) {
        this.name = name;
        this.link = link;
        this.nbParts = nbParts;
        this.making = making;
        this.calorie = calorie;
        this.recipeIngredients = recipeIngredients;
        this.menus = menus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getNbParts() {
        return nbParts;
    }

    public void setNbParts(int nbParts) {
        this.nbParts = nbParts;
    }

    public String getMaking() {
        return making;
    }

    public void setMaking(String making) {
        this.making = making;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Recipe [calorie=" + calorie + ", id=" + id + ", link=" + link + ", making=" + making + ", menus="
                + menus + ", name=" + name + ", nbParts=" + nbParts + ", recipeIngredients=" + recipeIngredients + "]";
    }

}
