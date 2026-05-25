package com.jpgedvila.opAbilities.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_elements")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "element")
    private Set<ParanormalPower> paranormalPowers = new HashSet<>();

    @OneToMany(mappedBy = "element")
    private Set<Item> items = new HashSet<>();

    public Element() {
    }

    public Element(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<ParanormalPower> getParanormalPowers() {
        return paranormalPowers;
    }

    public void setParanormalPowers(Set<ParanormalPower> paranormalPowers) {
        this.paranormalPowers = paranormalPowers;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(id, element.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
