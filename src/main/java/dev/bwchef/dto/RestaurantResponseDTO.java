package dev.bwchef.dto;

import dev.bwchef.model.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantResponseDTO {
    private Long id;
    private Long chefId;
    private String name;

    @Builder
    public RestaurantResponseDTO(Long id, Long chefId, String name) {
        this.id = id;
        this.chefId = chefId;
        this.name = name;
    }

    public static RestaurantResponseDTO from(Restaurant restaurant) {
        return RestaurantResponseDTO.builder()
                .id(restaurant.getId())
                .chefId(restaurant.getChef().getId())
                .name(restaurant.getName())
                .build();
    }
}
