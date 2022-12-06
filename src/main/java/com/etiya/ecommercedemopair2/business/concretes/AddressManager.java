package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.AddressService;
import com.etiya.ecommercedemopair2.business.abstracts.CountryService;
import com.etiya.ecommercedemopair2.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Address;
import com.etiya.ecommercedemopair2.entities.concretes.Country;
import com.etiya.ecommercedemopair2.repository.abstracts.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private CountryService countryService;

    @Override
    public AddAddressResponse addAddress(AddAddressRequest addAddressRequest) {
        Address address = new Address();
        address.setTitle(addAddressRequest.getTitle());
        Country country =countryService.getById(addAddressRequest.getCountry_id());


        address.setCountry(country);
        Address savedAddress=addressRepository.save(address);

        AddAddressResponse response=
                new AddAddressResponse(savedAddress.getId(),savedAddress.getTitle(),savedAddress.getCountry().getId());
        return response;
    }

    @Override
    public Address getById(int address_id) {
        //return addressRepository.findById(address_id).orElseThrow();
        return checkIfAddressExistsById(address_id);
    }

    private Address checkIfAddressExistsById(int address_id) {
        Address currentAddress = this.addressRepository.findById(address_id).orElseThrow();
        return currentAddress;
    }
}
