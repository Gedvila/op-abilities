package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.repositories.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository repository;
    public ItemService(ItemRepository repository){
        this.repository = repository;
    }

//    public Page<>
}
