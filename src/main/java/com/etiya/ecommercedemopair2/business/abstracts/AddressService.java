package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Address;

public interface AddressService {

    AddAddressResponse addAddress(AddAddressRequest addAddressRequest);

    Address getById(int address_id);
}
