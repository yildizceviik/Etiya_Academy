package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/add")
    public DataResult<AddCustomerResponse> addCustomer(@RequestBody @Valid AddCustomerRequest addCustomerRequest){
        return new DataResult<AddCustomerResponse>(customerService.addCustomer(addCustomerRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getById")
    public DataResult<Customer> getById(@RequestParam("id") int id){
        return customerService.getById(id);
    }
}
