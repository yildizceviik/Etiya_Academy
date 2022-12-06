package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.ProductService;
import com.etiya.ecommercedemopair2.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    //DI
    @Autowired
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/getById")
    public Product getByIdPath(@RequestParam("id") int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThanOrderByStockDesc")
    public List<Product> getAllByStock(@RequestParam("stock") int stock){
        return productService.getAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

//    public Product getByName(@RequestParam("name") String name){
//
//        return productService.getByName(name);
//    }
    @PostMapping("/add")
    public ResponseEntity<AddProductResponse>addProduct (@RequestBody @Valid AddProductRequest addProductRequest){
        return new ResponseEntity<AddProductResponse>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }
}
