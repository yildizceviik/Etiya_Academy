package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.OrderDetailsService;
import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.business.abstracts.ProductService;
import com.etiya.ecommercedemopair2.business.dtos.request.orderDetails.AddOrderDetailsRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.orderDetails.AddOrderDetailsResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Order;
import com.etiya.ecommercedemopair2.entities.concretes.OrderDetail;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.repository.abstracts.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailsManager implements OrderDetailsService {
    private OrderDetailsRepository orderDetailsRepository;
    private OrderService orderService;
    private ProductService productService;
    @Override
    public AddOrderDetailsResponse addOrderDetails(AddOrderDetailsRequest addOrderDetailsRequest) {
        OrderDetail orderDetail = new OrderDetail();
        Order order = orderService.getById(addOrderDetailsRequest.getOrder_id());
        orderDetail.setOrder(order);

        Product product = productService.getById(addOrderDetailsRequest.getProduct_id());
        orderDetail.setProduct(product);

        orderDetail.setTotal(addOrderDetailsRequest.getTotal());
        orderDetail.setCoupon(addOrderDetailsRequest.getCoupon());

        OrderDetail savedOrderDetail = orderDetailsRepository.save(orderDetail);

        AddOrderDetailsResponse response= new AddOrderDetailsResponse(savedOrderDetail.getId(), savedOrderDetail.getOrder().getId(),savedOrderDetail.getProduct().getId(),savedOrderDetail.getTotal(),savedOrderDetail.getCoupon());

        return response;
    }
}
