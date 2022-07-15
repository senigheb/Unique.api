package com.unique.unique_api.controllers.dto;

import java.util.Date;

public class OrderDTO {
    private String itemName;
    private Integer quantity;
    private Integer itemId;
    private Date orderDate;
    private Integer userId;
    private String shippingAddress;
    private String status;

    public OrderDTO(String itemName, Integer quantity, Integer itemId, Date orderDate, Integer userId, String shippingAddress, String status) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemId = itemId;
        this.orderDate = orderDate;
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.status = "waiting";
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
