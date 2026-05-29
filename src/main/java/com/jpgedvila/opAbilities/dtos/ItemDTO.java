package com.jpgedvila.opAbilities.dtos;

import com.jpgedvila.opAbilities.entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemDTO {

    private Long id;
    private String name;
    private Long category;
    private Long space;
    private String damage;
    private String range;
    private Long critRoll;
    private Long critMultiplier;
    private boolean isParanormal;
    private String description;

    private String element;

    private List<String> itemProperties = new ArrayList<>();

    private String damageKind;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String name, Long category, Long space, String damage, String range, Long critRoll, Long critMultiplier, boolean isParanormal, String description, String element, List<String> itemProperties, String damageKind) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.space = space;
        this.damage = damage;
        this.range = range;
        this.critRoll = critRoll;
        this.critMultiplier = critMultiplier;
        this.isParanormal = isParanormal;
        this.description = description;
        this.element = element;
        this.itemProperties = itemProperties;
        this.damageKind = damageKind;
    }

    public ItemDTO(Item entity){
        id = entity.getId();
        name = entity.getName();
        category = entity.getCategory();
        space = entity.getSpace();
        damage = entity.getDamage();
        range = entity.getRange();
        critRoll = entity.getCritRoll();
        critMultiplier = entity.getCritMultiplier();
        isParanormal = entity.isParanormal();
        description = entity.getDescription();
        element = entity.getElement().getName();
        damageKind = entity.getDamageKind().getName();

//        for (ItemItemProp prop : entity.getItemProperties()){
//            ItemProp itemProp = new ItemProp(prop);
//
//            itemProperties.add(itemProp.getName());
//        }
    }
}
