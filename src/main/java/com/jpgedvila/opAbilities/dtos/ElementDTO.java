package com.jpgedvila.opAbilities.dtos;

import com.jpgedvila.opAbilities.entities.Element;

public class ElementDTO {

    private Long id;
    private String name;


    public ElementDTO(){}

    public ElementDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ElementDTO(Element element){
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
