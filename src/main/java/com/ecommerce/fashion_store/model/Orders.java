package com.ecommerce.fashion_store.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Orders {

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "orderNumber",nullable = false)
    private String orderNumber;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName ="id"
    )
    private Customer customer;

    @ManyToOne
    @JoinColumn(
            name = "order_items",
            referencedColumnName = "id"
    )
    private User sender;
}
