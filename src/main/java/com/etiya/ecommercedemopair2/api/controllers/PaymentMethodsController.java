package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.PaymentMethodService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.paymentmethod.AddPaymentMethodRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.paymentmethod.AddPaymentMethodResponse;


import com.etiya.ecommercedemopair2.entities.concretes.PaymenMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"PaymentMethods")
public class PaymentMethodsController {

    private PaymentMethodService paymentMethodService;

    @GetMapping("")
    public List<PaymenMethod> getAll(){
        return paymentMethodService.getAll();
    }

   @Autowired
   PaymentMethodsController(PaymentMethodService paymentMethodService){
       this.paymentMethodService=paymentMethodService;
   }

    @PostMapping("/add")
    public ResponseEntity<AddPaymentMethodResponse> addPaymentMethod(@RequestBody @Valid AddPaymentMethodRequest addPaymentMethodRequest){
        return new ResponseEntity<AddPaymentMethodResponse>(paymentMethodService.addPaymentMethod(addPaymentMethodRequest), HttpStatus.CREATED);
    }
}
