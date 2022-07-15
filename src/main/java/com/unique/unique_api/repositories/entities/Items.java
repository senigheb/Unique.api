package com.unique.unique_api.repositories.entities;

import com.unique.unique_api.controllers.dto.ItemsDTO;

import javax.persistence.*;

@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Integer id;
    @Column(name="item_name")
    private String itemName;
    @Column(name="item_category")
    private String itemCategory;
    @Column(name="item_sub_category")
    private String itemSubCategory;
    @Column(name="item_price")
    private Double itemPrice;
    @Column(name="item_description")
    private String itemDescription;
    private String image;

    public Items() {
    }

    public Items(ItemsDTO itemsDTO) {
        this.itemName = itemsDTO.getItemName();
        this.itemCategory = itemsDTO.getItemCategory();
        this.itemSubCategory = itemsDTO.getItemSubCategory();
        this.itemPrice = itemsDTO.getItemPrice();
        this.itemDescription = itemsDTO.getItemDescription();
        this.image = itemsDTO.getImage();
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

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemSubCategory() {
        return itemSubCategory;
    }

    public void setItemSubCategory(String itemSubCategory) {
        this.itemSubCategory = itemSubCategory;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
