package com.ecommerce.fashion_store.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name="cart_item" )

public class cart_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "qty",nullable = false)
    private int qty;

    @Column(name="unit_price",nullable = false)
    private double unit_price;

    @Column(name = "amount",nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "id"
    )
    private Cart cart;

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private Product product;
}
