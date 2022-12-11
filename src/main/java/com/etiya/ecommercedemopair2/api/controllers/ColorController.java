package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.ColorService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"colors")
public class ColorController {
    private ColorService colorService;

    @Autowired
    ColorController(ColorService colorService){

        this.colorService=colorService;
    }

    @PostMapping("/add")
    public DataResult<AddColorResponse> addColor(@RequestBody @Valid AddColorRequest addColorRequest){
        return new DataResult<>(colorService.addColor(addColorRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getById")
    public DataResult<Color> getById(@RequestParam("id") int id){
        return colorService.getById(id);
    }
}
