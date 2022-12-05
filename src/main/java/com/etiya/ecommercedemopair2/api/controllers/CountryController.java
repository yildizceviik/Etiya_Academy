package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.CountryService;
import com.etiya.ecommercedemopair2.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.country.AddCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private CountryService countryService;

    @Autowired
    CountryController(CountryService countryService){
        this.countryService=countryService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddCountryResponse> addCountry(@RequestBody AddCountryRequest addCountryRequest){
        return new ResponseEntity<AddCountryResponse>(countryService.addCountry(addCountryRequest), HttpStatus.CREATED);
    }
}
