package com.etiya.ecommercedemopair2.business.dtos.request.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddCategoryRequest {

    private String name;
}
