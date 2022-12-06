package com.etiya.ecommercedemopair2.business.dtos.response.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDetailsResponse {
    private int id;
    private int order_id;
    private int product_id;
    private double total;
    private String coupon;
}
