package com.etiya.ecommercedemopair2.business.abstracts;



import com.etiya.ecommercedemopair2.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(int id);

    User getByName(String first_name);


}
