package com.etiya.ecommercedemopair2.business.dtos.response.salesman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddSalesmanResponse {
    private int id;
    private String company_name;
    private int role_id;
    private int user_id;

}
