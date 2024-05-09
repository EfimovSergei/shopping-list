package ru.efimov.shoppinglist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shopping_items")
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private User user;
}
