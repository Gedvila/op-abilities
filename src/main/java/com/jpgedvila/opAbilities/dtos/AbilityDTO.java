package com.jpgedvila.opAbilities.dtos;

import com.jpgedvila.opAbilities.entities.Ability;
import com.jpgedvila.opAbilities.entities.Archetype;

public class AbilityDTO {

    private Long id;
    private String name;
    private String prerequisite;
    private String description;
    private String archetype;

    public AbilityDTO(){}

    public AbilityDTO(Ability entity){
        id = entity.getId();
        name = entity.getName();
        prerequisite = entity.getPrerequisite();
        description = entity.getDescription();
        archetype = entity.getArchetype().getName();
    }

    public AbilityDTO(Long id, String name, String prerequisite, String description, String archetype) {
        this.id = id;
        this.name = name;
        this.prerequisite = prerequisite;
        this.description = description;
        this.archetype = archetype;
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

    public String getArchetype() {
        return archetype;
    }
}
