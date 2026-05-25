package com.jpgedvila.opAbilities.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jpgedvila.opAbilities.entities.DamageKind;

@JsonPropertyOrder({"id", "name", "description"})
public class DamageKindDTO {

    private Long id;
    private String name;
    private String description;

    public DamageKindDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public DamageKindDTO() {
    }

    public DamageKindDTO(DamageKind entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
