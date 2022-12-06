package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CityService;
import com.etiya.ecommercedemopair2.business.abstracts.CountryService;
import com.etiya.ecommercedemopair2.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair2.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.country.AddCountryResponse;
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
    @Override
    public AddCountryResponse addCountry(AddCountryRequest addCountryRequest) {
        Country country=new Country();

        country.setCountry_name(addCountryRequest.getCountry_name());
        City city =cityService.getById(addCountryRequest.getCity_id());
        country.setCity(city);

        Country savedCountry = countryRepository.save(country);

        AddCountryResponse response=
                new AddCountryResponse(savedCountry.getId(),savedCountry.getCountry_name(),savedCountry.getCity().getId());
        return response;

    }

    @Override
    public Country getById(int id) {
        return this.countryRepository.findById(id).orElseThrow();
    }


}
