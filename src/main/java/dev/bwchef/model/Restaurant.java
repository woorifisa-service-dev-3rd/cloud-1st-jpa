package dev.bwchef.model;

import dev.bwchef.dto.RestaurantRequestDTO;
import dev.bwchef.dto.RestaurantResponseDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter @NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private Chef chef;

    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

    @Builder
    public Restaurant(Long id, String name, Chef chef) {
        this.id = id;
        this.name = name;
        this.chef = chef;
    }

    public static Restaurant of(RestaurantRequestDTO restaurantRequestDTO, Chef chef) {
        return Restaurant.builder()
                .name(restaurantRequestDTO.getName())
                .chef(chef)
                .build();
    }

    public void renameRestaurant(String newName) {
        this.name = newName;
    }
}
