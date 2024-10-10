package dev.bwchef.controller;

import dev.bwchef.dto.RestaurantRequestDTO;
import dev.bwchef.dto.RestaurantResponseDTO;
import dev.bwchef.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDTO>> Getrestaurants() {
        List<RestaurantResponseDTO> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> GetrestaurantById(@PathVariable Long id) {
        RestaurantResponseDTO restaurant = restaurantService.getRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantResponseDTO> Postrestaurant(@RequestBody RestaurantRequestDTO restaurantRequestDTO) {
        RestaurantResponseDTO restaurant = restaurantService.saveRestaurant(restaurantRequestDTO);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> UpdateRestaurant(@PathVariable Long id,
                                                                  @RequestBody RestaurantRequestDTO restaurantRequestDTO) {
        RestaurantResponseDTO restaurant = restaurantService.updateRestaurant(id, restaurantRequestDTO);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
