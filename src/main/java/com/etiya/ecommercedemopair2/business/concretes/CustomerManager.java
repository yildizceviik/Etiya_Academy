package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Customer;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import com.etiya.ecommercedemopair2.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    private RoleService roleService;
    private UserService userService;
    @Override
    public AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest) {
        Customer customer=new Customer();
        customer.setPayment_id(addCustomerRequest.getPayment_id());

        Role role=roleService.getById(addCustomerRequest.getRole_id());
        customer.setRole(role);

        User user=userService.getById(addCustomerRequest.getUser_id());
        customer.setUser(user);

        Customer savedCustomer=customerRepository.save(customer);

        AddCustomerResponse response=
                new AddCustomerResponse(savedCustomer.getId(),savedCustomer.getPayment_id(),savedCustomer.getRole().getId(),savedCustomer.getUser().getId());
        return response;
    }

    @Override
    public Customer getById(int customer_id) {
        return customerRepository.findById(customer_id).orElseThrow();
    }
}
