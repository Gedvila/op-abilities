package com.jpgedvila.opAbilities.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jpgedvila.opAbilities.entities.Archetype;

@JsonPropertyOrder({"id", "name"})
public class ArchetypeDTO {

    private Long id;
    private String name;

    public ArchetypeDTO(){}

    public ArchetypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArchetypeDTO(Archetype entity){
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
