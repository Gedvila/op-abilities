package com.jpgedvila.opAbilities.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jpgedvila.opAbilities.entities.Element;
import com.jpgedvila.opAbilities.entities.ParanormalPower;

@JsonPropertyOrder({"id","name","prerequisite","description","element"})
public class ParanormalPowerDTO {

    private Long id;
    private String name;
    private String prerequisite;
    private String description;
    private Element element;

    public ParanormalPowerDTO(Long id, String name, String prerequisite, String description, Element element) {
        this.id = id;
        this.name = name;
        this.prerequisite = prerequisite;
        this.description = description;
        this.element = element;
    }

    public ParanormalPowerDTO(ParanormalPower entity){
        id = entity.getId();
        name = entity.getName();
        prerequisite = entity.getPrerequisite();
        description = entity.getDescription();
        element = entity.getElement();
    }

    public ParanormalPowerDTO(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public String getDescription() {
        return description;
    }

    public Element getElement() {
        return element;
    }
}
