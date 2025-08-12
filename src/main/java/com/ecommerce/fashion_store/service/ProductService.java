package com.ecommerce.fashion_store.service;

import com.ecommerce.fashion_store.CategoryEnum;
import com.ecommerce.fashion_store.dto.AddToCardDTO;
import com.ecommerce.fashion_store.dto.ProductCreateDTO;
import com.ecommerce.fashion_store.dto.ProductResponseDTO;
import com.ecommerce.fashion_store.model.Cart;
import com.ecommerce.fashion_store.model.CartItem;
import com.ecommerce.fashion_store.model.Product;
import com.ecommerce.fashion_store.model.User;
import com.ecommerce.fashion_store.repository.CartItemRepository;
import com.ecommerce.fashion_store.repository.CartRepository;
import com.ecommerce.fashion_store.repository.ProductRepository;
import com.ecommerce.fashion_store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final UserRepository userRepository;

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

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

    public List<ProductResponseDTO> findAllByCategory(CategoryEnum category){

        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for (Product product : productRepository.findAllByCategory(category)) {
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

    public void addToCard(AddToCardDTO addToCardDTO){

        User user = userRepository.findById(addToCardDTO.getUserId()).orElseThrow(
                () -> new RuntimeException("User not found"));

        Product product = productRepository.findById(addToCardDTO.getProductId()).orElseThrow(
                () -> new RuntimeException("Product not found")
        );

        Cart cart = new Cart();
        Optional<Cart> byUserId = cartRepository.findByUser_Id(user.getId());
        if (byUserId.isPresent()) {
            cart = byUserId.get();
            cart.setTotal(cart.getTotal() + product.getPrice());
        }else {
            cart.setUser(user);
            cart.setTotal(product.getPrice());
        }

        Cart savedCart = cartRepository.save(cart);

        CartItem cartItem = new CartItem();
        cartItem.setCart(savedCart);
        cartItem.setProduct(product);
        cartItem.setQty(addToCardDTO.getQuantity());
        cartItem.setUnitPrice(product.getPrice());
        cartItem.setAmount(product.getPrice() * addToCardDTO.getQuantity());

        cartItemRepository.save(cartItem);

    }
}
