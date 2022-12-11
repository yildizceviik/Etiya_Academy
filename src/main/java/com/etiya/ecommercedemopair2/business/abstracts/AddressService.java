package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Address;

public interface AddressService {

    DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest);

    DataResult<Address> getById(int address_id);
}
