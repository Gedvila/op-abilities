package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.Archetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchetypeRepository extends JpaRepository<Archetype, Long> {

    Archetype findByName(String name);
}
