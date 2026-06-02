package com.jpgedvila.opAbilities.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jpgedvila.opAbilities.entities.Item;
import com.jpgedvila.opAbilities.entities.ItemItemProp;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"id","name","category","space"," damage", "range","critRoll","critMultiplier","isParanormal","description","element","itemProperties","damageKind"})
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

    public ItemDTO(Item entity) {
        id = entity.getId();
        name = entity.getName();
        category = entity.getCategory();
        space = entity.getSpace();
        damage = entity.getDamage();
        range = entity.getRange();
        critRoll = entity.getCritRoll();
        critMultiplier = entity.getCritMultiplier();
        isParanormal = entity.isParanormal();
        if (isParanormal) {
            element = entity.getElement().getName();
        } else {
            element = "";
        }
        description = entity.getDescription();

        damageKind = entity.getDamageKind().getName();

        for (ItemItemProp prop : entity.getItemProperties()) {
            ItemItemPropDTO itemProp = new ItemItemPropDTO(prop);

            itemProperties.add(itemProp.getPropName());
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCategory() {
        return category;
    }

    public Long getSpace() {
        return space;
    }

    public String getDamage() {
        return damage;
    }

    public String getRange() {
        return range;
    }

    public Long getCritRoll() {
        return critRoll;
    }

    public Long getCritMultiplier() {
        return critMultiplier;
    }

    public boolean isParanormal() {
        return isParanormal;
    }

    public String getDescription() {
        return description;
    }

    public String getElement() {
        return element;
    }

    public List<String> getItemProperties() {
        return itemProperties;
    }

    public String getDamageKind() {
        return damageKind;
    }
}
