package com.unique.unique_api.repositories.entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemsRepository extends CrudRepository<Items, Integer> {
    //Creating Query methods
    List<Items> findByItemName(String itemName);
    List<Items> findByItemNameAndItemCategory(String itemName, String itemCategory);
    List<Items> findByItemNameAndItemCategoryAndItemSubCategory(String itemName, String itemCategory, String ItemSubCategory);
}
