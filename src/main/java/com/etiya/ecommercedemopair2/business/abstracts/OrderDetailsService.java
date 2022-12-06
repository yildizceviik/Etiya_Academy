package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.orderDetails.AddOrderDetailsRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.orderDetails.AddOrderDetailsResponse;

public interface OrderDetailsService {
    AddOrderDetailsResponse addOrderDetails(AddOrderDetailsRequest addOrderDetailsRequest);
}
