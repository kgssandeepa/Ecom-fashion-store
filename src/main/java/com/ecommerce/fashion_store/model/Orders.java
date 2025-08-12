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
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;
}
