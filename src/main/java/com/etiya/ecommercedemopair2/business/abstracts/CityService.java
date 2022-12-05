package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair2.entities.concretes.City;
import com.etiya.ecommercedemopair2.entities.concretes.District;

public interface CityService {
    AddCityResponse addCity (AddCityRequest addCityRequest);
    City getById(int id);
}
