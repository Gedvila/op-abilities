package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.ItemProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPropRepository extends JpaRepository<ItemProp, Long> {
}
