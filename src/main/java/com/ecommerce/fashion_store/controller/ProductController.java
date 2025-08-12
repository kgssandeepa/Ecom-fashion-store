package com.ecommerce.fashion_store.controller;

import com.ecommerce.fashion_store.dto.ProductCreateDTO;
import com.ecommerce.fashion_store.dto.ProductResponseDTO;
import com.ecommerce.fashion_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public void createProduct(@RequestBody ProductCreateDTO productCreateDTO){
        productService.createProduct(productCreateDTO);
    }

    @GetMapping("/find-all")
    public List<ProductResponseDTO> getProducts(){
        return productService.findAll();
    }

    @DeleteMapping("remove-product/{id}")
    public void removeProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
    }
}
