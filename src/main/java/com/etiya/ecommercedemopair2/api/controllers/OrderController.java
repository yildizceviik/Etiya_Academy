package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Order;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public List<Order> getAll(@RequestParam("id") int id ){
        return orderService.findAllOrdersOrderByOrder_date(id);
    }
//    @GetMapping("/getById")
//    public List<Order> findAllProductsUnitPriceBetween(@RequestParam("id") int id){
//        return orderService.findAllProductsUnitPriceBetween(id);
//    }

   @PostMapping("/add")
    public ResponseEntity<AddOrderResponse> addOrder(@RequestBody AddOrderRequest addOrderRequest){
       return new ResponseEntity<>(orderService.addOrder(addOrderRequest), HttpStatus.CREATED);
    }
}
