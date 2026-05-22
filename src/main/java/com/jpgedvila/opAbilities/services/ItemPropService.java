package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.ItemPropDTO;
import com.jpgedvila.opAbilities.entities.ItemProp;
import com.jpgedvila.opAbilities.repositories.ItemPropRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemPropService {

    private final ItemPropRepository repository;
    public ItemPropService(ItemPropRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ItemPropDTO> findAll(){
        List<ItemProp> list = repository.findAll();

        return list.stream().map(ItemPropDTO :: new).toList();
    }

    @Transactional(readOnly = true)
    public ItemPropDTO searchByName(String name){
        ItemProp entity = repository.searchByName(name);

        return new ItemPropDTO(entity);
    }

    @Transactional(readOnly = true)
    public ItemPropDTO findById(Long id){
        ItemProp entity  = repository.findById(id).orElseThrow();

        return new ItemPropDTO(entity);
    }

}
