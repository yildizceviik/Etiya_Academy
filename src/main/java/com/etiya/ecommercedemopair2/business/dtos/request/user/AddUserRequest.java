package com.etiya.ecommercedemopair2.business.dtos.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddUserRequest {

    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String password;
    private int address_id;
    private Date birth_date;

}
