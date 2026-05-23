package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.ElementDTO;
import com.jpgedvila.opAbilities.services.ElementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/elements")
public class ElementController {

    private final ElementService service;

    public ElementController(ElementService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ElementDTO>> findElement(@RequestParam(name = "id", defaultValue = "0") Long id) {

        List<ElementDTO> result = new ArrayList<>();

        if (id == 0) {
            result = service.findAll();
        } else {
            result.add(service.findById(id));
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<ElementDTO> updateElement(@RequestParam(name = "id") Long id, @RequestBody ElementDTO dto) {

        dto = service.update(id, dto);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ElementDTO> insertElement(@RequestBody ElementDTO dto) {
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("?id={id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteElement(@RequestParam(name = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
