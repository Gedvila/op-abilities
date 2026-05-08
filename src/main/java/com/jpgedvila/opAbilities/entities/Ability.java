package com.jpgedvila.opAbilities.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_abilities")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String prerequisite;
    private String description;

    public Ability(){}

    public Ability(Long id, String name, String prerequisite, String description) {
        this.id = id;
        this.name = name;
        this.prerequisite = prerequisite;
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

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ability ability = (Ability) o;
        return Objects.equals(id, ability.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
