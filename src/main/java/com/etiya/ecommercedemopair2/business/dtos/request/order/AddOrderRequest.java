package com.etiya.ecommercedemopair2.business.dtos.request.order;

import com.etiya.ecommercedemopair2.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddOrderRequest {

    private Date order_date;
    private Date ship_date;
    @Min(value=1,message = "shipper_id "+ Messages.Id.IdFieldNeedsToBeMinOne)
    private int shipperId;
    @Min(value=1,message = "payment_id "+Messages.Id.IdFieldNeedsToBeMinOne)
    private int paymentId;
    @Min(value=1,message = "customer_id "+Messages.Id.IdFieldNeedsToBeMinOne)
    private int customerId;
}
