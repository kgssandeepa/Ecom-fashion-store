package com.ecommerce.fashion_store.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderItem {

    @Id
    @GeneratedValue()
    private long id;


    @Column(name = "unit_price",nullable = false)
    private float unit_price;

    @Column(name ="quntity",nullable = false)
    private int quntity;

    @Column (name = "ammount",nullable = false)
    private float ammount;

    @ManyToOne
    @JoinColumn(
            name = "product",
            referencedColumnName = "id"
    )
    private Product product;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id"
    )
    private Orders order;




}
