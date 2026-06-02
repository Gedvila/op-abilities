package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.ItemDTO;
import com.jpgedvila.opAbilities.entities.Item;
import com.jpgedvila.opAbilities.repositories.ItemRepository;
import com.jpgedvila.opAbilities.services.exceptions.DatabaseException;
import com.jpgedvila.opAbilities.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {


    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ItemDTO> findAll(String name, Pageable pageable) {
        Page<Item> result = repository.searchByName(name, pageable);

        return result.map(ItemDTO::new);
    }

    @Transactional
    public ItemDTO insert(ItemDTO dto) {
        Item entity = new Item();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);

        return new ItemDTO(entity);
    }

    @Transactional
    public ItemDTO update(Long id, ItemDTO dto) {
        try {
            Item entity = repository.getReferenceById(id);
            copyDtoToEntity(entity, dto);

            entity = repository.save(entity);

            return new ItemDTO(entity);

        } catch (Exception e) {
            throw new ResourceNotFoundException("Item não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {

            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(Item entity, ItemDTO dto) {
    }
}
