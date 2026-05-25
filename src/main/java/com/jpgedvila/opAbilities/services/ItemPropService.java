package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.ItemPropDTO;
import com.jpgedvila.opAbilities.entities.ItemProp;
import com.jpgedvila.opAbilities.repositories.ItemPropRepository;
import com.jpgedvila.opAbilities.services.exceptions.DatabaseException;
import com.jpgedvila.opAbilities.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemPropService {

    private final ItemPropRepository repository;

    public ItemPropService(ItemPropRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ItemPropDTO> findAll() {
        List<ItemProp> list = repository.findAll();

        return list.stream().map(ItemPropDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<ItemPropDTO> searchByName(String name) {
        try {

            List<ItemProp> list = repository.searchByName(name);

            return list.stream().map(ItemPropDTO :: new).toList();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(readOnly = true)
    public ItemPropDTO findById(Long id) {

        try {
            ItemProp entity = repository.findById(id).orElseThrow();

            return new ItemPropDTO(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public ItemPropDTO insert(ItemPropDTO dto) {
        ItemProp entity = new ItemProp();
        copyDTOtoEntity(entity, dto);

        entity = repository.save(entity);

        return new ItemPropDTO(entity);
    }

    @Transactional
    public ItemPropDTO update(Long id, ItemPropDTO dto) {
        try {
            ItemProp entity = repository.getReferenceById(id);
            copyDTOtoEntity(entity, dto);

            entity = repository.save(entity);

            return new ItemPropDTO(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
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

    private void copyDTOtoEntity(ItemProp entity, ItemPropDTO dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }
}