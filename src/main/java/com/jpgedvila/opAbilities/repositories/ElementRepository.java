package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element,Long> {

    @Query("SELECT obj FROM Element obj WHERE UPPER(obj.name) LIKE  UPPER(CONCAT('%',:name,'%'))")
    Element searchByName(String name);
}
