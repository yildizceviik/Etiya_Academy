package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.salesman.AddSalesmanRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.AddSalesmanResponse;

public interface SalesmanServise {
    AddSalesmanResponse addSalesman(AddSalesmanRequest addSalesmanRequest);
}
