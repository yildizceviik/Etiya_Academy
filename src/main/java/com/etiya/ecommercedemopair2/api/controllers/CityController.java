package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.CityService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.city.AddCityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"cities")
public class CityController {
    private CityService cityService;

    @Autowired
    CityController(CityService cityService){
        this.cityService=cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddCityResponse> addCity(@RequestBody @Valid AddCityRequest addCityRequest){
        return new ResponseEntity<AddCityResponse>(cityService.addCity(addCityRequest), HttpStatus.CREATED);
    }
}
