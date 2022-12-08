package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.user.AddUserResponse;
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

//    @GetMapping("/getUserAll")
//    public List<User> getAll(){
//        return this.userService.getAll();
//    }
//
//    @GetMapping("/getByUserId")
//    public User getById(@RequestParam int id){
//        return this.userService.getById(id);
//    }
//
//    @GetMapping("getByFirstName")
//    public User getByFirstName(@RequestParam("name") String name){
//        return userService.getByFirst_name(name);
//    }
    @PostMapping("/add")
    public ResponseEntity<AddUserResponse> addUser(@RequestBody @Valid AddUserRequest addUserRequest) {
        return new ResponseEntity<AddUserResponse>(userService.addUser(addUserRequest), HttpStatus.CREATED);
    }
}
