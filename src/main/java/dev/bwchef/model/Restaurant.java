package dev.bwchef.model;

import dev.bwchef.dto.RestaurantRequestDTO;
import dev.bwchef.dto.RestaurantResponseDTO;
import jakarta.persistence.*;
// <<<<<<< dev-jjinny
import java.util.ArrayList;
import java.util.List;

@Entity
// =======
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;

// import java.util.List;

// @Entity
// @Getter @NoArgsConstructor
// >>>>>>> dev
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

// <<<<<<< dev-jjinny
    private String name;

    @ManyToOne
// =======
//     @ManyToOne(fetch = FetchType.LAZY)
// >>>>>>> dev
    @JoinColumn(name = "chef_id")
    private Chef chef;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

// <<<<<<< dev-jjinny
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Chef getChef() { return chef; }
    public void setChef(Chef chef) { this.chef = chef; }

    public List<Menu> getMenus() { return menus; }
    public void setMenus(List<Menu> menus) { this.menus = menus; }
// =======
//     @OneToMany(mappedBy = "restaurant")
//     private List<Menu> menus;

//     @Builder
//     public Restaurant(Long id, String name, Chef chef) {
//         this.id = id;
//         this.name = name;
//         this.chef = chef;
//     }

//     public static Restaurant of(RestaurantRequestDTO restaurantRequestDTO, Chef chef) {
//         return Restaurant.builder()
//                 .name(restaurantRequestDTO.getName())
//                 .chef(chef)
//                 .build();
//     }

//     public void renameRestaurant(String newName) {
//         this.name = newName;
//     }
// >>>>>>> dev
}

