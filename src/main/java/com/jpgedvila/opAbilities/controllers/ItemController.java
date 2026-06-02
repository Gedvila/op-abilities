package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.ItemDTO;
import com.jpgedvila.opAbilities.services.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemService service;
    public ItemController(ItemService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ItemDTO>> findAll(@RequestParam(name = "name" ,defaultValue = "") String name, Pageable pageable){
        Page<ItemDTO> result = service.findAll(name, pageable);

        return ResponseEntity.ok().body(result);
    }
}
