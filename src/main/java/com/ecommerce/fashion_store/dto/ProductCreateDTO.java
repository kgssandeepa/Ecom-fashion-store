package com.ecommerce.fashion_store.dto;

import com.ecommerce.fashion_store.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO {

    private String name;
    private double newPrice;
    private double oldPrice;
    private String description;
    private CategoryEnum category;



}
