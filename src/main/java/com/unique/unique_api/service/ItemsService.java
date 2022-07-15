package com.unique.unique_api.service;

import com.unique.unique_api.controllers.dto.ItemsDTO;
import com.unique.unique_api.repositories.entities.Items;

public interface ItemsService {
    Items save(ItemsDTO itemsDTO);
    Items update(ItemsDTO itemsDTO, Integer id);
    void delete(Integer id);
    Iterable<Items> findAll();
    Items findById(Integer id);
}
