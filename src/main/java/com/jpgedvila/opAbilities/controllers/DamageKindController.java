package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.DamageKindDTO;
import com.jpgedvila.opAbilities.services.DamageKindService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/dmgkind")
public class DamageKindController {

    private final DamageKindService service;

    public DamageKindController(DamageKindService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DamageKindDTO>> findAll(@RequestParam(name = "id", defaultValue = "0") Long id) {
        List<DamageKindDTO> list = new ArrayList<>();
        if (id == 0) {
            list = service.findAll();
        } else {
            list.add(service.findById(id));
        }

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<DamageKindDTO> insert(@RequestBody DamageKindDTO dto) {
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("?id={id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public ResponseEntity<DamageKindDTO> update(@RequestParam(name = "id") Long id, @RequestBody DamageKindDTO dto) {
        dto = service.update(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam(name = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}