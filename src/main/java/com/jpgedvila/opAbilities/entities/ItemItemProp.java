package com.jpgedvila.opAbilities.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_item_item_prop")
@IdClass(ItemItemPropPK.class)
public class ItemItemProp {

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_prop_id")
    private ItemProp itemProp;


    public ItemItemProp() {
    }

    public ItemItemProp(Item item, ItemProp itemProp) {
        this.item = item;
        this.itemProp = itemProp;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemProp getItemProp() {
        return itemProp;
    }

    public void setItemProp(ItemProp itemProp) {
        this.itemProp = itemProp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemItemProp that = (ItemItemProp) o;
        return Objects.equals(item, that.item) && Objects.equals(itemProp, that.itemProp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, itemProp);
    }
}
