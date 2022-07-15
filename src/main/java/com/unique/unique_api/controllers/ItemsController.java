package com.unique.unique_api.controllers;

import com.unique.unique_api.controllers.dto.ItemsDTO;
import com.unique.unique_api.repositories.entities.Items;
import com.unique.unique_api.repositories.entities.ItemsRepository;
import com.unique.unique_api.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {
    private final ItemsService itemsService;
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @PostMapping("/addItem")
    public Items addItem(@RequestBody ItemsDTO itemsDTO) {
        return itemsService.save(itemsDTO);
    }

    @GetMapping
    public Iterable<Items> getItems() {
        return itemsService.findAll();
    }
    @GetMapping("/{id}")
    public Items getItems(@PathVariable("id") Integer id) {
        return itemsService.findById(id);
    }

    @PutMapping("/{id}")
    public Items updateItem(@RequestBody ItemsDTO itemsDTO, @PathVariable("id") Integer id) {
        return itemsService.update(itemsDTO, id);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        itemsService.delete(id);
    }

    @Autowired
    ItemsRepository itemRepo;

    @GetMapping("/itemName")
    public ResponseEntity<List<Items>> getItemByName(@RequestParam String itemName) {
        return new ResponseEntity<>(itemRepo.findByItemName(itemName), HttpStatus.OK);
    }

    @GetMapping("/nameAndCategory")
    public ResponseEntity<List<Items>> getItemByNameAndCategory(@RequestParam String itemName, @RequestParam String itemCategory) {
        return new ResponseEntity<>(itemRepo.findByItemNameAndItemCategory(itemName, itemCategory), HttpStatus.OK);
    }

    @GetMapping("/nameCategorySubCategory")
    public ResponseEntity<List<Items>> getItemByNameAndCategoryAndSubCategory(@RequestParam String itemName, @RequestParam String itemCategory, @RequestParam String itemSubCategory) {
        return new ResponseEntity<>(itemRepo.findByItemNameAndItemCategoryAndItemSubCategory(itemName, itemCategory, itemSubCategory), HttpStatus.OK);
    }



}
