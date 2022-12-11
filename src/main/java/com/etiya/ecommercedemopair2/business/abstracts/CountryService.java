package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemopair2.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Country;
import com.etiya.ecommercedemopair2.entities.concretes.District;

public interface CountryService {

    DataResult<AddCountryResponse> addCountry (AddCountryRequest addCountryRequest);

    DataResult<Country> getById(int id);
}
