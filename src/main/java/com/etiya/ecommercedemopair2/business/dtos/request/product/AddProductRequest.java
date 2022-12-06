package com.etiya.ecommercedemopair2.business.dtos.request.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddProductRequest {
    @NotNull(message = "İsim alanı boş bırakılamaz")
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @Min(value = 1,message = "Ürün fiyatı en az 1 birim olmalıdır.")
    private double unit_price;
    @Min(value = 0,message = "Stok sayısı en az 0 olmalıdır.")
    private int stock;
    @Min(value = 0,message = "Id sıfırdan küçük olamaz.")
    private int category_id;
    private int color_id;
    private int sale_count;
}
