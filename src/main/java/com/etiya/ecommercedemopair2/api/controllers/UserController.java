package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/getUserAll")
    public List<User> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/getByUserId")
    public User getById(@RequestParam int id){
        return this.userService.getById(id);
    }

    @GetMapping("getUserFirstName")
    public User getByName(@RequestParam("first_name") String first_name){
        return  userService.getByName(first_name);
    }

}
