package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.ParanormalPowerDTO;
import com.jpgedvila.opAbilities.services.ParanormalPowerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(name = "/parpw")
public class ParanormalPowerController {

    private final ParanormalPowerService service;
    public ParanormalPowerController(ParanormalPowerService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ParanormalPowerDTO>> findAll(Pageable pageable, @RequestParam(name = "name",defaultValue = "") String name){
        Page<ParanormalPowerDTO> result = service.findAll(name, pageable);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<ParanormalPowerDTO> insert (@RequestBody ParanormalPowerDTO dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("?id={id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public ResponseEntity<ParanormalPowerDTO> update (@RequestParam(name = "id") Long id,@RequestBody ParanormalPowerDTO dto){
        dto = service.update(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteElement(@RequestParam(name = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
