package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CityService;
import com.etiya.ecommercedemopair2.business.abstracts.CountryService;
import com.etiya.ecommercedemopair2.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair2.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.entities.concretes.City;
import com.etiya.ecommercedemopair2.entities.concretes.Country;
import com.etiya.ecommercedemopair2.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair2.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {

    private CountryRepository countryRepository;
    private CityService cityService;
    private ModelMapperService modelMapperService;
    @Override
    public AddCountryResponse addCountry(AddCountryRequest addCountryRequest) {
        Country country=modelMapperService.getMapper().map(addCountryRequest,Country.class);

        Country savedCountry = countryRepository.save(country);

        AddCountryResponse response=
                modelMapperService.getMapper().map(savedCountry,AddCountryResponse.class);
        return response;

    }

    @Override
    public Country getById(int id) {
        return this.countryRepository.findById(id).orElseThrow();
    }


}
