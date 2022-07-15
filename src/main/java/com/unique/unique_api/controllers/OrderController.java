package com.unique.unique_api.controllers;


import com.unique.unique_api.controllers.dto.OrderDTO;
import com.unique.unique_api.repositories.entities.Orders;
import com.unique.unique_api.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/newOrder")
    public Orders createOrder(@RequestBody OrderDTO newOrderDTO){
        return orderService.save(newOrderDTO);
    }

    @GetMapping
    public Iterable<Orders> getOrder(){
        return orderService.findAll();
    }

    @GetMapping("/find")
    public Orders findOrderByItemName(@RequestParam String itemName){
        return orderService.findByItemName(itemName);
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable("id") Integer orderId){
        return orderService.findById(orderId);
    }


    @PutMapping("/{id}")
    public Orders updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable("id") Integer orderId) {
        return orderService.update(orderDTO, orderId);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Integer orderId){
            orderService.delete(orderId);
        }
}
