package com.jpgedvila.opAbilities.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

    @OneToMany(mappedBy = "item")
    private Set<ItemItemProp> itemProperties = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "damage_kind_id")
    private DamageKind damageKind;

    public Item(){}

    public Item(Long id, String name, Long category, Long space, String damage, String range, Long critRoll, Long critMultiplier, boolean isParanormal, String description) {
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getSpace() {
        return space;
    }

    public void setSpace(Long space) {
        this.space = space;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Long getCritRoll() {
        return critRoll;
    }

    public void setCritRoll(Long critRoll) {
        this.critRoll = critRoll;
    }

    public Long getCritMultiplier() {
        return critMultiplier;
    }

    public void setCritMultiplier(Long critMultiplier) {
        this.critMultiplier = critMultiplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isParanormal() {
        return isParanormal;
    }

    public void setParanormal(boolean paranormal) {
        isParanormal = paranormal;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Set<ItemItemProp> getItemProperties() {
        return itemProperties;
    }

    public void setItemProperties(Set<ItemItemProp> itemProperties) {
        this.itemProperties = itemProperties;
    }

    public DamageKind getDamageKind() {
        return damageKind;
    }

    public void setDamageKind(DamageKind damageKind) {
        this.damageKind = damageKind;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
