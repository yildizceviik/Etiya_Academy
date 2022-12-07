package com.etiya.ecommercedemopair2.business.dtos.request.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddAddressRequest {
    @NotNull
    @NotBlank
    private String title;
    @Min(value=1,message = "country_id en az 1 olmalıdır.")
    private int countryId;
}
