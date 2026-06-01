package com.jpgedvila.opAbilities.dtos;

import com.jpgedvila.opAbilities.entities.ItemItemProp;

public class ItemItemPropDTO {

    private String propName;

    public ItemItemPropDTO(ItemItemProp itemItemProp){
        propName = itemItemProp.getItemProp().getName();
    }

}