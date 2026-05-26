package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.ArchetypeDTO;
import com.jpgedvila.opAbilities.entities.Archetype;
import com.jpgedvila.opAbilities.repositories.ArchetypeRepository;
import com.jpgedvila.opAbilities.services.exceptions.DatabaseException;
import com.jpgedvila.opAbilities.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class ArchetypeService {

    private final ArchetypeRepository repository;

    public ArchetypeService(ArchetypeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ArchetypeDTO> findAll() {
        List<Archetype> list = repository.findAll();

        return list.stream().map(ArchetypeDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ArchetypeDTO findById(Long id) {
        Archetype entity = repository.findById(id).orElseThrow(
                () -> new ResolutionException("Recurso não encontrado")
        );

        return new ArchetypeDTO(entity);
    }

    @Transactional
    public ArchetypeDTO insert(ArchetypeDTO dto) {
        Archetype entity = new Archetype();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);

        return new ArchetypeDTO(entity);
    }

    @Transactional
    public ArchetypeDTO update(Long id, ArchetypeDTO dto) {
        try {

            Archetype entity = repository.getReferenceById(id);
            copyDtoToEntity(entity, dto);

            entity = repository.save(entity);

            return new ArchetypeDTO(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Classe não encontrada");
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


    private void copyDtoToEntity(Archetype entity, ArchetypeDTO dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
    }
}
