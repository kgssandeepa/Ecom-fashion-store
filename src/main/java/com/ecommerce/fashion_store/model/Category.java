package com.ecommerce.fashion_store.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="code",nullable = false)
    private String code;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
