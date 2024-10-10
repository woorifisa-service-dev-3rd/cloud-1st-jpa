package dev.bwchef.dto;

import dev.bwchef.model.MenuType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuResponseDTO {
    private Long id;
    private String name;
    private Long price;
    private MenuType menuType;
}
