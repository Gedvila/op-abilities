package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.Element;
import com.jpgedvila.opAbilities.entities.ItemProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPropRepository extends JpaRepository<ItemProp, Long> {

    @Query("SELECT obj FROM ItemProp obj WHERE UPPER(obj.name) LIKE  UPPER(CONCAT('%',:name,'%'))")
    ItemProp searchByName(String name);
}
