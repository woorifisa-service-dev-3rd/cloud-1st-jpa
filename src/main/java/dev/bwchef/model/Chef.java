package dev.bwchef.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;  // @JoinColumn 제거
    private String name;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public List<Restaurant> getRestaurants() { return restaurants; }
    public void setRestaurants(List<Restaurant> restaurants) { this.restaurants = restaurants; }
}