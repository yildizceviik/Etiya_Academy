package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.AddressService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.address.AddAddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    AddressController(AddressService addressService){
        this.addressService=addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddAddressResponse> addAddress (@RequestBody @Valid AddAddressRequest addAddressRequest){
        return new ResponseEntity<AddAddressResponse>(addressService.addAddress(addAddressRequest), HttpStatus.CREATED);
    }
}
