package dev.bwchef.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    private MenuType menuType;

    @Nullable
    private String name;

    @Nullable
    private Long price;

    private String content;

}
