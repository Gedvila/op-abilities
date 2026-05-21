package com.jpgedvila.opAbilities.dtos;

import com.jpgedvila.opAbilities.entities.ItemProp;

public class ItemPropDTO {

    private Long id;
    private String name;
    private String description;

    public ItemPropDTO(ItemProp itemProp){
        id = itemProp.getId();
        name = itemProp.getName();
        description = itemProp.getDescription();
    }

    public ItemPropDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
