package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair2.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.entities.concretes.Category;
import com.etiya.ecommercedemopair2.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;



    @Override
    public List<Category> getAll() {

        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(int categoryId) {

        return this.categoryRepository.findById(categoryId).orElseThrow();
    }

    @Override
    public Category getByName(String name) {

        return categoryRepository.findByName(name);
    }

    @Override
    public Category customGetByName(String name) {

        return categoryRepository.customFindByName(name);
    }

    //JPA Repository Save methodu, eklenen veriyi geri döner
    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {

        //MAPPING=> Auto mapper

        //Manual mapper
    //        Category category = new Category();
    //        category.setName(addCategoryRequest.getName());
        //
        Category category =modelMapperService.getMapper().map(addCategoryRequest,Category.class);
        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        Category savedCategory = categoryRepository.save(category);

        //MAPPING=> Category = addcategoryresponse
        AddCategoryResponse response =
                modelMapperService.getMapper().map(savedCategory,AddCategoryResponse.class);
        return response;
        //
    }
    private void categoryCanNotExistWithSameName(String name){

        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(isExists) // Veritabanımda bu isimde bir kategori mevcut!!

            throw new RuntimeException("Bu isimle bir kategori zaten mevcut!");
    }

}
