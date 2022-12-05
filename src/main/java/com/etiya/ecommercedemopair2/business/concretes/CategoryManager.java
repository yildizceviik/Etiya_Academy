package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair2.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Category;
import com.etiya.ecommercedemopair2.repository.abstracts.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        //
        Category savedCategory =categoryRepository.save(category);

        //MAPPING=> Category = addcategoryresponse
        AddCategoryResponse response=
                new AddCategoryResponse(savedCategory.getId(),savedCategory.getName());

        return response;
    }
}
