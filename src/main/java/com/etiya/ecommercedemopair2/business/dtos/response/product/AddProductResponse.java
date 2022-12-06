package com.etiya.ecommercedemopair2.business.dtos.response.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddProductResponse {
    private int id;
    private String name;
    private double unit_price;
    private int stock;
    private int category_id;
    private int color_id;
    private int sale_count;
}
