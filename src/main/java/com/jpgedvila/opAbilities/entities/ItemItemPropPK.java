package com.jpgedvila.opAbilities.entities;

import jakarta.persistence.*;

import java.util.Objects;


public class ItemItemPropPK {

    private Long item;

    private Long itemProp;

    public ItemItemPropPK(){}

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public Long getItemProp() {
        return itemProp;
    }

    public void setItemProp(Long itemProp) {
        this.itemProp = itemProp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemItemPropPK that = (ItemItemPropPK) o;
        return Objects.equals(item, that.item) && Objects.equals(itemProp, that.itemProp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, itemProp);
    }
}
