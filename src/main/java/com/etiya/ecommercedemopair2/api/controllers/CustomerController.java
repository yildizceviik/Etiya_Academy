package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.customer.AddCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<AddCustomerResponse> addCustomer(@RequestBody @Valid AddCustomerRequest addCustomerRequest){
        return new ResponseEntity<AddCustomerResponse>(customerService.addCustomer(addCustomerRequest), HttpStatus.CREATED);
    }
}
