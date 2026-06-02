package com.jpgedvila.opAbilities.dtos;

import com.jpgedvila.opAbilities.entities.ItemItemProp;

public class ItemItemPropDTO {

    private String propName;

    public ItemItemPropDTO(ItemItemProp itemItemProp){
        propName = itemItemProp.getItemProp().getName();
    }

    public ItemItemPropDTO(){}

    public ItemItemPropDTO(String propName) {
        this.propName = propName;
    }

    public String getPropName() {
        return propName;
    }
}