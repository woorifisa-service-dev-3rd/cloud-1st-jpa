package dev.bwchef.dto;

import dev.bwchef.model.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantRequestDTO {
    private Long chefId;
    private String name;

    @Builder
    public RestaurantRequestDTO(Long chefId, String name) {
        this.chefId = chefId;
        this.name = name;
    }

    public static RestaurantRequestDTO from(Restaurant restaurant) {
        return RestaurantRequestDTO.builder()
                .chefId(restaurant.getChef().getId())
                .name(restaurant.getName())
                .build();
    }
}
