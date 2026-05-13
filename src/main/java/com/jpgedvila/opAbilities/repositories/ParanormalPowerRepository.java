package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.ParanormalPower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParanormalPowerRepository extends JpaRepository<ParanormalPower, Long> {
}
