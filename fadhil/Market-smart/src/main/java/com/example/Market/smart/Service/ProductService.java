package com.example.Market.smart.Service;

import com.example.Market.smart.Model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product>getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);

}
