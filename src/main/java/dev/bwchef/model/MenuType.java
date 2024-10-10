package dev.bwchef.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MenuType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "menuType", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Menu> getMenus() { return menus; }
    public void setMenus(List<Menu> menus) { this.menus = menus; }
}