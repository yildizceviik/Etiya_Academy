package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.role.AddRoleRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.role.AddRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    RoleController(RoleService roleService){
        this.roleService=roleService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddRoleResponse> addRole (@RequestBody @Valid AddRoleRequest addRoleRequest){
        return new ResponseEntity<AddRoleResponse>(roleService.addRole(addRoleRequest), HttpStatus.CREATED);
    }
}
