package com.ecommerce.fashion_store.model;


import com.ecommerce.fashion_store.CategoryEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

public class Product {

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name ="price",nullable = true)
    private double price;

    @Column(name = "old_price")
    private double oldPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnum category;

}
