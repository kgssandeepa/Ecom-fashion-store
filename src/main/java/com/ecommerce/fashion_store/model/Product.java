package com.ecommerce.fashion_store.model;


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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name ="price",nullable = true)
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private category category;
}
