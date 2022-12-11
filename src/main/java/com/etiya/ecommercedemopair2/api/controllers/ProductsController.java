package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.ProductService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"products")
public class ProductsController {
    //DI
    @Autowired
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }
    @PostMapping("/addResult")
    public DataResult<AddProductResponse> add(@RequestBody @Valid AddProductRequest addProductRequest){
        return new DataResult<AddProductResponse>(productService.addProduct(addProductRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getProductById")
    public DataResult<List<AddProductResponse>> getProductById(@RequestParam("id") int identity){
        return productService.getProductById(identity);
    }



    @GetMapping("{id}")
    public DataResult<Product> getById(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/getById")
    public DataResult<Product> getByIdPath(@RequestParam("id") int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThanOrderByStockDesc")
    public DataResult<List<Product>> getAllByStock(@RequestParam("stock") int stock){
        return productService.getAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }




}
