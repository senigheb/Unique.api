package com.unique.unique_api.repositories;

import com.unique.unique_api.repositories.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer>{
    Orders findByItemName(String itemName);
}
