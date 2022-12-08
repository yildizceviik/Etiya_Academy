package com.etiya.ecommercedemopair2.business.dtos.request.shipper;

import com.etiya.ecommercedemopair2.business.constants.Messages;
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
public class AddShipperRequest {
    @NotNull(message = Messages.Name.NameFieldCantBeEmpty)
    @NotBlank(message = Messages.Name.NameFieldCantBeEmpty)
    private String company_name;
    @NotNull(message = "Telefon numarası boş bırakılamaz!")
    private String phone_number;
    @Min(value=1,message = "role_id "+Messages.Id.IdFieldNeedsToBeMinOne)
    private int roleId;
}
