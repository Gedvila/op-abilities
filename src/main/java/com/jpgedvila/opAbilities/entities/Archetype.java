package com.jpgedvila.opAbilities.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_archetypes")
public class Archetype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "archetype")
    private Set<Ability> ability = new HashSet<>();

    public Archetype(){}

    public Archetype(Long id,String name) {
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

    public Set<Ability> getAbility() {
        return ability;
    }

    public void setAbility(Set<Ability> ability) {
        this.ability = ability;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Archetype archetype = (Archetype) o;
        return Objects.equals(id, archetype.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
