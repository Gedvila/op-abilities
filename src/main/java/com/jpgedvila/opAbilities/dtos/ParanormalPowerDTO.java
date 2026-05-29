package com.jpgedvila.opAbilities.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jpgedvila.opAbilities.entities.Element;
import com.jpgedvila.opAbilities.entities.ParanormalPower;

@JsonPropertyOrder({"id", "name", "prerequisite", "description", "element"})
public class ParanormalPowerDTO {

    private Long id;
    private String name;
    private String prerequisite;
    private String description;
    private String element;
    private String affinity;

    public ParanormalPowerDTO(Long id, String name, String prerequisite, String description, String element, String affinity) {
        this.id = id;
        this.name = name;
        this.prerequisite = prerequisite;
        this.description = description;
        this.element = element;
        this.affinity = affinity;
    }

    public ParanormalPowerDTO(ParanormalPower entity) {
        id = entity.getId();
        name = entity.getName();
        prerequisite = entity.getPrerequisite();
        description = entity.getDescription();
        element = entity.getElement().getName();
        affinity = entity.getAffinity();
    }

    public ParanormalPowerDTO() {
    }

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

    public String getElement() {
        return element;
    }

    public String getAffinity() {
        return affinity;
    }
}
