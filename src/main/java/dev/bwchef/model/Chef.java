package dev.bwchef.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Chef {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ChefType type;

    @OneToMany(mappedBy = "chef")
    private List<Restaurant> restaurants = new ArrayList<>();

}
