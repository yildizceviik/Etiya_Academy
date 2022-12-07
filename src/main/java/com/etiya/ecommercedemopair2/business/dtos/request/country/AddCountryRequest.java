package com.etiya.ecommercedemopair2.business.dtos.request.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddCountryRequest {

    private String country_name;
    private int cityId;
}
