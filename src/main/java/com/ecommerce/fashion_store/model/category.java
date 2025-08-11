package com.ecommerce.fashion_store.model;

import jakarta.persistence.*;


@Entity
@Table(name = "category")
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="code",nullable = false)
    private String code;
}
