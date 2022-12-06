package com.etiya.ecommercedemopair2.repository.abstracts;

import com.etiya.ecommercedemopair2.entities.concretes.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<Salesman,Integer> {
}
