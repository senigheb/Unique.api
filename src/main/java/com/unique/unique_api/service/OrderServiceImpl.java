package com.unique.unique_api.service;

import com.unique.unique_api.repositories.OrderRepository;
import com.unique.unique_api.controllers.dto.OrderDTO;
import com.unique.unique_api.repositories.entities.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Orders save(OrderDTO orderDTO) {
//        converting an OrderDTO to an Order entity
        Orders orders = new Orders(orderDTO);
        return orderRepository.save(orders);
    }

    @Override
    public Orders update(OrderDTO orderDTO, Integer orderId) {
        //        find the order to update
        Orders orderFromDb = findById(orderId);

//        update the order information
        if(orderDTO.getItemName() == null){
            orderFromDb.setItemName(orderFromDb.getItemName());
        } else if(orderDTO.getItemName().isEmpty()) {
            orderFromDb.setItemName(orderFromDb.getItemName());
        } else {
            orderFromDb.setItemName(orderDTO.getItemName());
        }

        orderFromDb.setQuantity(orderDTO.getQuantity() != null ? orderDTO.getQuantity() : orderFromDb.getQuantity());
        orderFromDb.setStatus(orderDTO.getStatus() != null ? orderDTO.getStatus() : orderFromDb.getStatus());
        orderFromDb.setShippingAddress(orderDTO.getShippingAddress() != null ? orderDTO.getShippingAddress() : orderFromDb.getShippingAddress());
        orderFromDb.setOrderDate(orderDTO.getOrderDate() != null ? orderDTO.getOrderDate() : orderFromDb.getOrderDate());
        orderFromDb.setItemId(orderDTO.getItemId() !=null ? orderDTO.getItemId() : orderFromDb.getItemId());
        orderFromDb.setUserId(orderDTO.getUserId() != null ? orderDTO.getUserId() : orderFromDb.getUserId());
//        save the order back to the DB
//        return the order to the client
        return orderRepository.save(orderFromDb);
    }

    @Override
    public void delete(Integer orderId) {
        Optional<Orders> orderToDelete = orderRepository.findById(orderId);

        if(orderToDelete.isPresent()){
            orderRepository.deleteById(orderId);
            throw new ResponseStatusException(HttpStatus.OK, "The order has been successfully deleted");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The order was not found.");
        }
    }

    @Override
    public Iterable<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Orders findById(Integer orderId) {
        Optional<Orders> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isEmpty()){
            return null;
        }
        return optionalOrder.get();
    }

    @Override
    public Orders findByItemName(String name){
        return orderRepository.findByItemName(name);
    }

}
