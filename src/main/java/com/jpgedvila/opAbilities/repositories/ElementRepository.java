package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element,Long> {
}
