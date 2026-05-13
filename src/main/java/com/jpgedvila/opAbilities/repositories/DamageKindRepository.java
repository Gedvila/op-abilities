package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.DamageKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageKindRepository extends JpaRepository<DamageKind,Long> {
}
