package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.ArchetypeDTO;
import com.jpgedvila.opAbilities.services.ArchetypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/arch")
public class ArchetypeController {

    private final ArchetypeService service;

    public ArchetypeController(ArchetypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ArchetypeDTO>> findAll(@RequestParam(name = "id", defaultValue = "0") Long id) {
        List<ArchetypeDTO> list = new ArrayList<>();

        if (id != 0) {
            list.add(service.findById(id));
        } else {
            list = service.findAll();
        }

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ArchetypeDTO> insert(@RequestBody ArchetypeDTO dto) {
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("?id={id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public ResponseEntity<ArchetypeDTO> update(@RequestParam(name = "id") Long id, @RequestBody ArchetypeDTO dto) {
        dto = service.update(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam(name = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}