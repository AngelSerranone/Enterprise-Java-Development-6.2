package com.ironhack.Products.controller.interfaces;

import com.ironhack.Products.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductController {

    public Product getProductById(Integer id);
}
