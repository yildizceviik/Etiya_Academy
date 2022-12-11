package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int categoryId);

    DataResult<Category> getByName(String name);

    DataResult<Category> customGetByName(String name);

    DataResult<AddCategoryResponse> addCategory (AddCategoryRequest addCategoryRequest);

}
