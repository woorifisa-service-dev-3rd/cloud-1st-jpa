package dev.bwchef.controller;


import dev.bwchef.dto.MenuDetailDTO;
import dev.bwchef.dto.MenuResponseDTO;
import dev.bwchef.model.MenuType;
import dev.bwchef.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 특정 레스토랑의 모든 메뉴 조회
    @GetMapping("/menu/{restaurantId}")
    public List<MenuResponseDTO> getMenusByRestaurantId(@PathVariable int restaurantId) {
        return menuService.findAllByRestaurantId(restaurantId);
    }

    // 특정 레스토랑의 메뉴 타입으로 필터링하여 조회
    @GetMapping("/menu/filtered")
    public List<MenuResponseDTO> getFilteredMenus(
            @RequestParam int restaurantId,
            @RequestParam MenuType menuType) {
        return menuService.findAllByRestaurantIdAndMenuType(restaurantId, menuType);
    }

    // 특정 메뉴의 상세 정보 조회
    @GetMapping("/menu/detail/{menuId}")
    public MenuDetailDTO getMenuDetail(@PathVariable Long menuId) {
        return menuService.findMenuDetailById(menuId);
    }
}