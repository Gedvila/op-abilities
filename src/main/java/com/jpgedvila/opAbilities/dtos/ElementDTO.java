package com.jpgedvila.opAbilities.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jpgedvila.opAbilities.entities.Element;

@JsonPropertyOrder({"id", "name"})
public class ElementDTO {

    private Long id;
    private String name;


    public ElementDTO() {
    }

    public ElementDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ElementDTO(Element element) {
        id = element.getId();
        name = element.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
