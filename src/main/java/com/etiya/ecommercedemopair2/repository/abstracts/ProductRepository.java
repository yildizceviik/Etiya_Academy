package com.etiya.ecommercedemopair2.repository.abstracts;

import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    // Stock sayısına göre stock alanı gelen int değerden fazla olan productlar
    List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    // JPQL
    @Query("Select p from Product as p WHERE product_name=:name")
    Product findByName(String name);

}
