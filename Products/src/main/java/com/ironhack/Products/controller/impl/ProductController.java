package com.ironhack.Products.controller.impl;

import com.ironhack.Products.controller.Dto.ProductDto;
import com.ironhack.Products.controller.interfaces.IProductController;
import com.ironhack.Products.model.Product;
import com.ironhack.Products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "The product you are looking for doesn't exists");
        }
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product registerProduct(@RequestBody @Valid ProductDto productDto) {

        Product product = new Product(
                productDto.getProductName(),
                productDto.getProductPrice(),
                productDto.getInventoryCount()
        );

        return productRepository.save(product);
    }

    @PutMapping("/product-update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody @Valid ProductDto productDto) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            product.get().setInventoryCount(productDto.getInventoryCount());
            return productRepository.save(product.get());
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "The product you are looking for doesn't exists");
        }
    }
}
