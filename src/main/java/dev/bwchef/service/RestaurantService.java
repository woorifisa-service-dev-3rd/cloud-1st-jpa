package dev.bwchef.service;

import dev.bwchef.dto.RestaurantRequestDTO;
import dev.bwchef.dto.RestaurantResponseDTO;
import dev.bwchef.model.Chef;
import dev.bwchef.model.Restaurant;
import dev.bwchef.repository.ChefRepository;
import dev.bwchef.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ChefRepository chefRepository;
    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, ChefRepository chefRepository) {
        this.restaurantRepository = restaurantRepository;
        this.chefRepository = chefRepository;
    }

    public List<RestaurantResponseDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantResponseDTO> restaurantResponse = restaurants.stream()
                .map(RestaurantResponseDTO::from).collect(Collectors.toList());
        return restaurantResponse;
    }

    public RestaurantResponseDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(id+"에 해당하는 레스토랑이 존재하지 않습니다."));
        return RestaurantResponseDTO.from(restaurant);
    }

    @Transactional
    public RestaurantResponseDTO saveRestaurant(RestaurantRequestDTO restaurantRequestDTO) {
        Chef chef = chefRepository.findById(restaurantRequestDTO.getChefId())
                .orElseThrow(() -> new RuntimeException(restaurantRequestDTO.getChefId() + "에 해당하는 셰프가 없습니다."));
        Restaurant restaurant = Restaurant.of(restaurantRequestDTO, chef);
        return RestaurantResponseDTO.from(restaurantRepository.save(restaurant));
    }

    @Transactional
    public RestaurantResponseDTO updateRestaurant(Long id, RestaurantRequestDTO restaurantRequestDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + "에 해당하는 레스토랑이 존재하지 않습니다."));
        return null;
    }
}
