package com.unique.unique_api.controllers.dto;

public class ItemsDTO {
    private static String itemName;
    private String itemCategory;
    private String itemSubCategory;
    private Double itemPrice;
    private String itemDescription;
    private String image;

    public ItemsDTO(String itemName, String itemCategory, String itemSubCategory, Double itemPrice, String itemDescription, String image) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.image = image;
    }

    public static String getItemName() {
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
