package com.etiya.ecommercedemopair2.business.dtos.response.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddOrderWithCustomerNameResponse {
    private String name;
    private String last_name;
    private int id;
    private Date order_date;
    private Date ship_date;
    private int shipper_id;
    private int payment_id;
    private int customer_id;
}
