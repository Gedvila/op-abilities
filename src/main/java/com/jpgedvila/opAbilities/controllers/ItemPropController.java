package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.ItemPropDTO;
import com.jpgedvila.opAbilities.services.ItemPropService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prop")
public class ItemPropController {

    private final ItemPropService service;

    public ItemPropController(ItemPropService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemPropDTO>> findProp(@RequestParam(name = "name", defaultValue = "0") String name) {
        List<ItemPropDTO> list = new ArrayList<>();

        if (name.equals("0")) {
            list = service.findAll();
        } else {
            list = service.searchByName(name);
        }

        return ResponseEntity.ok().body(list);
    }

    @PutMapping
    public ResponseEntity<ItemPropDTO> update(@RequestParam(name = "id") Long id, @RequestBody ItemPropDTO dto) {
        dto = service.update(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ItemPropDTO> insertElement(@RequestBody ItemPropDTO dto) {
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("?id={id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteElement(@RequestParam(name = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}