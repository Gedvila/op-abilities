package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.AbilityDTO;
import com.jpgedvila.opAbilities.services.AbilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/ability")
public class AbilityController {

    private final AbilityService service;

    public AbilityController(AbilityService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<AbilityDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable) {
        Page<AbilityDTO> result = service.findAll(name, pageable);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<AbilityDTO> insert(AbilityDTO dto) {
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("?id={id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public ResponseEntity<AbilityDTO> update(@RequestParam(name = "id") Long id, @RequestBody AbilityDTO dto) {
        dto = service.update(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteElement(@RequestParam(name = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
