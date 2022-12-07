package com.etiya.ecommercedemopair2.business.dtos.request.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddOrderRequest {

    private Date order_date;
    private Date ship_date;
    private int shipperId;
    private int paymentId;
    private int customerId;
}
