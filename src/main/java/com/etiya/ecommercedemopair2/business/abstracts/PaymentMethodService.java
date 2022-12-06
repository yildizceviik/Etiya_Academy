package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.paymentmethod.AddPaymentMethodRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.paymentmethod.AddPaymentMethodResponse;
import com.etiya.ecommercedemopair2.entities.concretes.PaymenMethod;


import java.util.List;

public interface PaymentMethodService {

    List<PaymenMethod> getAll();

    PaymenMethod getById(int id);

    AddPaymentMethodResponse addPaymentMethod(AddPaymentMethodRequest addPaymentMethodRequest);
}
