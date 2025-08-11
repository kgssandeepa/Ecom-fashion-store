package com.ecommerce.fashion_store.repository;

import com.ecommerce.fashion_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
