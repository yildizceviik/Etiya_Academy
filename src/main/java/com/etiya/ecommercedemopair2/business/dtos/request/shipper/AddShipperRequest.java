package com.etiya.ecommercedemopair2.business.dtos.request.shipper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddShipperRequest {
    private String company_name;
    private String phone_number;
    private int role_id;
}
