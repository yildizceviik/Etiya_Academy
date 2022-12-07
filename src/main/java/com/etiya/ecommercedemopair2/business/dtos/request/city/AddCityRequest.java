package com.etiya.ecommercedemopair2.business.dtos.request.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddCityRequest {
    private String city_name;
    private int districtId;

}
