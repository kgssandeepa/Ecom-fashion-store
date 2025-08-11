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

    @ManyToOne
    @JoinColumn(
            name = "category_id", // specifies the name of the foreign key column in the database
            referencedColumnName = "id" // primary key of the user who owns this MESSAGE
    )
    private Category category;
}
