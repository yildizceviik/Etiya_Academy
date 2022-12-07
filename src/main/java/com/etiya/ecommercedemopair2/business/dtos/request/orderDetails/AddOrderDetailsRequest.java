package com.etiya.ecommercedemopair2.business.dtos.request.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDetailsRequest {
    private int orderId;
    private int productId;
    private double total;
    private String coupon;
}
