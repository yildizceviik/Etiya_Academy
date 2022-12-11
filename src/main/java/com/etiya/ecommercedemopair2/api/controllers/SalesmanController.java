package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.SalesmanServise;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.salesman.AddSalesmanRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.AddSalesmanResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"salesmans")
public class SalesmanController {

    private SalesmanServise salesmanServise;

    @Autowired
    SalesmanController(SalesmanServise salesmanServise){
        this.salesmanServise=salesmanServise;
    }

    @PostMapping("/add")
    public DataResult<AddSalesmanResponse> addSalesman (@RequestBody @Valid AddSalesmanRequest addSalesmanRequest){
        return new DataResult<AddSalesmanResponse>(salesmanServise.addSalesman(addSalesmanRequest).getData(),true,"Başarılı");
    }
}
