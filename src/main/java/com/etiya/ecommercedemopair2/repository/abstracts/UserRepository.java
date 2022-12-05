package com.etiya.ecommercedemopair2.repository.abstracts;


import com.etiya.ecommercedemopair2.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("Select u from User as u WHERE first_name=:first_name")
    User findByUserName(String first_name);


}
