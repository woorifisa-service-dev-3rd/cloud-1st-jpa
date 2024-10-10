package dev.bwchef.dto;

import dev.bwchef.model.MenuType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuDetailDTO {
    private String name;
    private Long price;
    private MenuType menuType;
    private String content;
}
