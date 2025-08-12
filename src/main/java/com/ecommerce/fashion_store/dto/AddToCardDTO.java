package com.ecommerce.fashion_store.dto;


import com.ecommerce.fashion_store.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCardDTO {

   private Long userId;
   private Long productId;
   private int quantity;
}
