package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CityService;
import com.etiya.ecommercedemopair2.business.abstracts.DistrictService;
import com.etiya.ecommercedemopair2.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair2.entities.concretes.City;
import com.etiya.ecommercedemopair2.entities.concretes.District;
import com.etiya.ecommercedemopair2.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair2.repository.abstracts.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityManager implements CityService {

    private CityRepository cityRepository;
    private DistrictService districtService;
    @Override
    public AddCityResponse addCity(AddCityRequest addCityRequest) {
        City city = new City();
        city.setCity_name(addCityRequest.getCity_name());
        District district=
                districtService.getById(addCityRequest.getDistrict_id());

        city.setDistrict(district);
        City savedCity = cityRepository.save(city);

        AddCityResponse response=
                new AddCityResponse(savedCity.getId(),savedCity.getCity_name(),savedCity.getDistrict().getId());
        return response;
    }

    @Override
    public City getById(int id) {

        return cityRepository.findById(id).orElseThrow();
    }
}
