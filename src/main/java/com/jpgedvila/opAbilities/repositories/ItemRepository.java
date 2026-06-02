package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.Item;
import com.jpgedvila.opAbilities.entities.ParanormalPower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT obj FROM Item obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Item> searchByName(String name, Pageable pageable);
}
