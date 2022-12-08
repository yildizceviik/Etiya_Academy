package com.etiya.ecommercedemopair2.business.dtos.request.salesman;

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
public class AddSalesmanRequest {
    @NotNull(message = Messages.Name.NameFieldCantBeEmpty)
    @NotBlank(message = Messages.Name.NameFieldCantBeEmpty)
    private String company_name;
    @Min(value=1,message = "role_id "+Messages.Id.IdFieldNeedsToBeMinOne)
    private int roleId;
    @Min(value=1,message = "user_id "+Messages.Id.IdFieldNeedsToBeMinOne)
    private int userId;
}
