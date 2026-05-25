package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Long> {
}
