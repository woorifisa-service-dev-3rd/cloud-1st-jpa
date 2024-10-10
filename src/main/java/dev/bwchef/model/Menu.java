package dev.bwchef.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

// <<<<<<< dev-jjinny
//     private String name;
//     private Long price;

//     @ManyToOne
//     @JoinColumn(name = "restaurant_id")
//     private Restaurant restaurant;

//     @ManyToOne
//     @JoinColumn(name = "menu_type_id")
//     private MenuType menuType;

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public Long getPrice() { return price; }
//     public void setPrice(Long price) { this.price = price; }

//     public Restaurant getRestaurant() { return restaurant; }
//     public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
// =======
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    private MenuType menuType;

    @Nullable
    private String name;

    @Nullable
    private Long price;

    private String content;
// >>>>>>> dev

    public MenuType getMenuType() { return menuType; }
    public void setMenuType(MenuType menuType) { this.menuType = menuType; }
}