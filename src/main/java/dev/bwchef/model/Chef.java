package dev.bwchef.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Chef {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    private String name;

    @Enumerated(EnumType.STRING)
    private ChefType type;

    @OneToMany(mappedBy = "chef")
    private List<Restaurant> restaurants = new ArrayList<>();

}
