package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.orderDetails.AddOrderDetailsRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.orderDetails.AddOrderDetailsResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;

public interface OrderDetailsService {
    DataResult<AddOrderDetailsResponse> addOrderDetails(AddOrderDetailsRequest addOrderDetailsRequest);
}
