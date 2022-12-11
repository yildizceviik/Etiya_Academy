package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair2.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"users")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<User> getById(@PathVariable int id){
        return this.userService.getById(id);
    }
    @PostMapping("/add")
    public DataResult<AddUserResponse> addUser(@RequestBody @Valid AddUserRequest addUserRequest) {
        return new DataResult<AddUserResponse>(userService.addUser(addUserRequest).getData(),true,"Başarılı");
    }
}
