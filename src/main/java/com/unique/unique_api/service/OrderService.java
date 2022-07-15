package com.unique.unique_api.service;

import com.unique.unique_api.controllers.dto.OrderDTO;
import com.unique.unique_api.repositories.entities.Orders;

public interface OrderService {
    Orders save(OrderDTO orderDTO);

    Orders update(OrderDTO orderDTO, Integer orderId);

    void delete(Integer orderId);

    Iterable<Orders> findAll();

    Orders findById(Integer orderId);

    Orders findByItemName(String ItemName);
}
