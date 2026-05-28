package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.Ability;
import com.jpgedvila.opAbilities.entities.ParanormalPower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Long> {

    @Query("SELECT obj FROM Ability obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Ability> searchByName(String name, Pageable pageable);
}
