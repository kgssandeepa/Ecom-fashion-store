package com.ecommerce.fashion_store.repository;

import com.ecommerce.fashion_store.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

}
