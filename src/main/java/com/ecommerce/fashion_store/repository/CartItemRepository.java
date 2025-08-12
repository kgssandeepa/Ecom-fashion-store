package com.ecommerce.fashion_store.repository;

import com.ecommerce.fashion_store.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
