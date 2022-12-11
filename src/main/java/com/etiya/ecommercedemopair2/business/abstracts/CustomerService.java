package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Customer;

public interface CustomerService {
    DataResult<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest);

    DataResult<Customer> getById(int customer_id);
}
