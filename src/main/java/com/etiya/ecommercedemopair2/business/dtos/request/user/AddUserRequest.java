package com.etiya.ecommercedemopair2.business.dtos.request.user;

import com.etiya.ecommercedemopair2.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddUserRequest {
    @NotNull(message = Messages.Name.NameFieldCantBeEmpty)
    @NotBlank(message = Messages.Name.NameFieldCantBeEmpty)
    private String first_name;
    @NotNull(message = Messages.Name.NameFieldCantBeEmpty)
    @NotBlank(message = Messages.Name.NameFieldCantBeEmpty)
    private String last_name;
    @NotNull(message = "Telefon numarası boş bırakılamaz!")
    private String phone_number;
    @NotNull(message = "E mail alanı boş bırakılamaz!")
    //TODO: E mail formatında yazılsın
    private String email;
    @Size(min = 8,message = "Şifre alanı en az 8 karakter verilmelidir.")
    private String password;
    @Min(value=1,message = "address_id "+Messages.Id.IdFieldNeedsToBeMinOne)
    private int addressId;
    private Date birth_date;

}
