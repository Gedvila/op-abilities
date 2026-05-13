package com.jpgedvila.opAbilities.repositories;

import com.jpgedvila.opAbilities.entities.ItemItemProp;
import com.jpgedvila.opAbilities.entities.ItemItemPropPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemItemPropRepository extends JpaRepository<ItemItemProp, ItemItemPropPK> {
}
