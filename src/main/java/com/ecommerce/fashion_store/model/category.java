package com.ecommerce.fashion_store.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="code",nullable = false)
    private String code;

    @OneToOne(mappedBy = "category")
    private Product product;

}
