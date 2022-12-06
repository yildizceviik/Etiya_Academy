package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.OrderDetailsService;
import com.etiya.ecommercedemopair2.business.dtos.request.orderDetails.AddOrderDetailsRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.orderDetails.AddOrderDetailsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderDetails")
@AllArgsConstructor
public class OrderDetailsController {
    private OrderDetailsService orderDetailsService;

    @PostMapping("/add")
    public ResponseEntity<AddOrderDetailsResponse> addOrderDetail(@RequestBody AddOrderDetailsRequest addOrderDetailsRequest){
        return new ResponseEntity<>(orderDetailsService.addOrderDetails(addOrderDetailsRequest), HttpStatus.CREATED);
    }

}
