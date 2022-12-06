package com.etiya.ecommercedemopair2.repository.abstracts;


import com.etiya.ecommercedemopair2.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("Select u from User as u WHERE first_name=:first_name")
    User findByUserName(String first_name);


    List<User> findByEmail(String email);

    @Query("Select u from User as u WHERE first_name=:name")
    User findByFirst_name(String name);
}
