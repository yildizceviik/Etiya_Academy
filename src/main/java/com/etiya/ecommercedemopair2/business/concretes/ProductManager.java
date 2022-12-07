package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair2.business.abstracts.ColorService;
import com.etiya.ecommercedemopair2.business.abstracts.ProductService;
import com.etiya.ecommercedemopair2.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.entities.concretes.Category;
import com.etiya.ecommercedemopair2.entities.concretes.Color;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;
    private ColorService colorService;

    private ModelMapperService modelMapperService;

    //DEPENDENCY INJECTION


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllProductsByStockGreaterThanOrderByStockDesc(int stock) {
        return productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
//        Product product=new Product();
//        product.setName(addProductRequest.getName());
//        product.setUnit_price(addProductRequest.getUnit_price());
//        product.setStock(addProductRequest.getStock());
//        product.setSale_count(addProductRequest.getSale_count());
//
//        Category category =categoryService.getById(addProductRequest.getCategory_id());
//        product.setCategory(category);
//
//        Color color =colorService.getById(addProductRequest.getColor_id());
//        product.setColor(color);

        Product product=modelMapperService.getMapper().map(addProductRequest,Product.class);

        Product savedProduct=productRepository.save(product);

        AddProductResponse response=
                modelMapperService.getMapper().map(savedProduct, AddProductResponse.class);
        return response;

    }


}
