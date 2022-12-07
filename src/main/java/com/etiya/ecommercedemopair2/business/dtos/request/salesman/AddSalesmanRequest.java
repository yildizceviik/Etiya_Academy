package com.etiya.ecommercedemopair2.business.dtos.request.salesman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddSalesmanRequest {
    private String company_name;
    private int roleId;
    private int userId;
}
