package com.jpgedvila.opAbilities.controllers;

import com.jpgedvila.opAbilities.dtos.ElementDTO;
import com.jpgedvila.opAbilities.services.ElementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/elements")
public class ElementController {

    private final ElementService service;
    public ElementController(ElementService service){
        this.service =service;
    }

    @GetMapping
    public ResponseEntity<List<ElementDTO>> findElement(@RequestParam(name = "id", defaultValue = "0") Long id){

        List<ElementDTO> result = new ArrayList<>();

        if (id == 0){
              result = service.findAll();
        } else {
            result.add(service.findById(id));
        }

        return ResponseEntity.ok(result);
    }
}
