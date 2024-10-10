package dev.bwchef.service;

import dev.bwchef.dto.MenuDetailDTO;
import dev.bwchef.dto.MenuResponseDTO;
import dev.bwchef.model.Menu;
import dev.bwchef.model.MenuType;
import dev.bwchef.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public List<MenuResponseDTO> findAllByRestaurantId(int restaurantId) {
        List<Menu> menus = menuRepository.findAllByRestaurantId(restaurantId);
        return menus.stream()
                .map(menu -> new MenuResponseDTO(menu.getId(), menu.getName(), menu.getPrice(), menu.getMenuType()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MenuResponseDTO> findAllByRestaurantIdAndMenuType(int restaurantId, MenuType menuType) {
        List<Menu> menus = menuRepository.findAllByRestaurantIdAndMenuType(restaurantId, menuType);
        return menus.stream()
                .map(menu -> new MenuResponseDTO(menu.getId(), menu.getName(), menu.getPrice(), menu.getMenuType()))
                .collect(Collectors.toList());
    }

    @Transactional
    public MenuDetailDTO findMenuDetailById(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("메뉴를 찾을 수 없습니다.")); // 예외 처리

        return new MenuDetailDTO(menu.getName(), menu.getPrice(), menu.getMenuType(), menu.getContent());
    }
}
