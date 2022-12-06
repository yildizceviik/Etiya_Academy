package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.business.abstracts.PaymentMethodService;
import com.etiya.ecommercedemopair2.business.abstracts.ShipperService;
import com.etiya.ecommercedemopair2.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Customer;
import com.etiya.ecommercedemopair2.entities.concretes.Order;
import com.etiya.ecommercedemopair2.entities.concretes.PaymenMethod;
import com.etiya.ecommercedemopair2.entities.concretes.Shipper;
import com.etiya.ecommercedemopair2.repository.abstracts.OrderRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderRepositoy orderRepositoy;
    private ShipperService shipperService;
    private PaymentMethodService paymentMethodService;
    private CustomerService customerService;
    @Override
    public List<Order> findAllOrdersOrderByOrder_date(int id) {
        return orderRepositoy.getAllOrdersOrderById(id);
        //return null;
    }

    @Override
    public Order getById(int order_id) {
        return null;
    }

    @Override
    public AddOrderResponse addOrder(AddOrderRequest addOrderRequest) {
        Order order = new Order();

        order.setOrder_date(addOrderRequest.getOrder_date());
        order.setShip_date(addOrderRequest.getShip_date());

        Shipper shipper= shipperService.getById(addOrderRequest.getShipper_id());
        order.setShipper(shipper);

        PaymenMethod paymentMethod = paymentMethodService.getById(addOrderRequest.getPayment_id());
        order.setPaymentMethod(paymentMethod);

        Customer customer= customerService.getById(addOrderRequest.getCustomer_id());
        order.setCustomer(customer);

        Order savedOrder = orderRepositoy.save(order);

        AddOrderResponse response = new AddOrderResponse(savedOrder.getId(),savedOrder.getOrder_date(),savedOrder.getShip_date(),savedOrder.getShipper().getId(),savedOrder.getPaymentMethod().getId(),savedOrder.getCustomer().getId());

        return response;
    }
//    public List<Order> findAllProductsUnitPriceBetween(int id){
//        return orderRepositoy.findAllProductsUnitPriceBetween(id);
//    }
}
