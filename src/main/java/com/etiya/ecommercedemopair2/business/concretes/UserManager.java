package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.AddressService;
import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.entities.concretes.Address;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import com.etiya.ecommercedemopair2.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair2.repository.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByFirst_name(String name) {
        return userRepository.findByFirst_name(name);
    }

    @Override
    public AddUserResponse addUser(AddUserRequest addUserRequest) {
        User user=modelMapperService.getMapper().map(addUserRequest,User.class);

        User savedUser = userRepository.save(user);

        AddUserResponse response =
                modelMapperService.getMapper().map(savedUser,AddUserResponse.class);
        return response;
    }

    private Address checkIfAddressExistsById(int address_id) {
        Address currentAddress = this.addressRepository.findById(address_id).orElseThrow();
        return currentAddress;
    }
}
