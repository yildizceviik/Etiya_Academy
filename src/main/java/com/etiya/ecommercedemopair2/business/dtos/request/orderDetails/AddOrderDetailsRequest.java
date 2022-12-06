package com.etiya.ecommercedemopair2.business.dtos.request.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDetailsRequest {
    private int order_id;
    private int product_id;
    private double total;
    private String coupon;
}
