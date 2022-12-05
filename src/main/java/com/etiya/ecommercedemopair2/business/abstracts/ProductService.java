package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);

    List<Product> getAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    Product getByName(String name);
}
