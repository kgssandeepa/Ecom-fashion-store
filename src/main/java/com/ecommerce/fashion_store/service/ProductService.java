package com.ecommerce.fashion_store.service;

import com.ecommerce.fashion_store.dto.ProductCreateDTO;
import com.ecommerce.fashion_store.dto.ProductResponseDTO;
import com.ecommerce.fashion_store.model.Product;
import com.ecommerce.fashion_store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductCreateDTO productCreateDTO){

        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setPrice(productCreateDTO.getNewPrice());
        product.setOldPrice(productCreateDTO.getOldPrice());
        product.setCategory(productCreateDTO.getCategory());
        product.setDescription(productCreateDTO.getDescription());

        productRepository.save(product);
    }

    public List<ProductResponseDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        for (Product product : products) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();

            productResponseDTO.setId(product.getId());
            productResponseDTO.setName(product.getName());
            productResponseDTO.setDescription(product.getDescription());
            productResponseDTO.setNewPrice(product.getPrice());
            productResponseDTO.setOldPrice(product.getOldPrice());
            productResponseDTO.setCategory(product.getCategory());

            productResponseDTOS.add(productResponseDTO);
        }

        return productResponseDTOS;
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
}
