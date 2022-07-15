package com.unique.unique_api.service;

import com.unique.unique_api.controllers.dto.ItemsDTO;
import com.unique.unique_api.repositories.entities.Items;
import com.unique.unique_api.repositories.entities.ItemsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService{
    private final ItemsRepository itemsRepository;
    public ItemsServiceImpl(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @Override
    public Items save(ItemsDTO itemsDTO) {
        Items item = new Items(itemsDTO);
        return itemsRepository.save(item);
    }


    @Override
    public Items findById(Integer id) {
        Optional<Items> optionalItem = itemsRepository.findById(id);
            if(optionalItem.isEmpty()){
                return null;
            }
        return optionalItem.get();
    }

    @Override
    public Iterable<Items> findAll() {
        return itemsRepository.findAll();
    }

    @Override
    public Items update(ItemsDTO itemsDTO, Integer id) {
        //find item to update
        Items itemToUpdate = findById(id);
        //update item information
        if (ItemsDTO.getItemName() == null || ItemsDTO.getItemName().isEmpty()) {
            itemToUpdate.setItemName(itemToUpdate.getItemName());
        } else {
            itemToUpdate.setItemName(itemsDTO.getItemName());
        }

        itemToUpdate.setItemCategory(itemsDTO.getItemCategory().isEmpty() || itemsDTO.getItemCategory() == null ? itemToUpdate.getItemCategory() : itemsDTO.getItemCategory());
        itemToUpdate.setItemSubCategory(itemsDTO.getItemSubCategory().isEmpty() || itemsDTO.getItemSubCategory() == null ? itemToUpdate.getItemSubCategory() : itemsDTO.getItemSubCategory());
        itemToUpdate.setItemPrice(itemsDTO.getItemPrice() == null || itemsDTO.getItemPrice() <= 0 ? itemToUpdate.getItemPrice() : itemsDTO.getItemPrice());
        itemToUpdate.setItemDescription(itemsDTO.getItemDescription().isEmpty() || itemsDTO.getItemDescription() == null ? itemToUpdate.getItemDescription() : itemsDTO.getItemDescription());
        itemToUpdate.setImage(itemsDTO.getImage().isEmpty() || itemsDTO.getImage() == null ? itemToUpdate.getImage() : itemsDTO.getImage());

        return itemsRepository.save(itemToUpdate);
    }

    @Override
    public void delete(Integer id) {
        //find item to delete
        Optional<Items> itemToDelete = itemsRepository.findById(id);
        //delete item
        if(itemToDelete.isPresent()) {
            itemsRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.OK, "The item has been deleted");
        }
        throw new ResponseStatusException(HttpStatus.OK, "The item was not found");

    }



}
