package com.unique.unique_api.repositories.entities;
import com.unique.unique_api.controllers.dto.OrderDTO;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "item_name")
    private String itemName;
    private Integer quantity;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "order_status")
    private String status;



    public Orders() {
    }

    public Orders(OrderDTO orderDTO) {
        this.itemName = orderDTO.getItemName();
        this.itemId = orderDTO.getItemId();
        this.quantity = orderDTO.getQuantity();
        this.orderDate = orderDTO.getOrderDate();
        this.userId = orderDTO.getUserId();
        this.shippingAddress = orderDTO.getShippingAddress();
        this.status = orderDTO.getStatus();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", itemId=" + itemId +
                ", orderDate=" + orderDate +
                ", userId=" + userId +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
