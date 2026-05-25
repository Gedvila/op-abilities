package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.DamageKindDTO;
import com.jpgedvila.opAbilities.entities.DamageKind;
import com.jpgedvila.opAbilities.repositories.DamageKindRepository;
import com.jpgedvila.opAbilities.services.exceptions.DatabaseException;
import com.jpgedvila.opAbilities.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DamageKindService {

    private final DamageKindRepository repository;

    public DamageKindService(DamageKindRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<DamageKindDTO> findAll() {
        List<DamageKind> list = repository.findAll();

        return list.stream().map(DamageKindDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public DamageKindDTO findById(Long id) {
        try {
            DamageKind entity = repository.getReferenceById(id);

            return new DamageKindDTO(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public DamageKindDTO insert(DamageKindDTO dto) {
        DamageKind entity = new DamageKind();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);

        return new DamageKindDTO(entity);
    }

    @Transactional
    public DamageKindDTO update(Long id, DamageKindDTO dto) {
        try {
            DamageKind entity = repository.getReferenceById(id);
            copyDtoToEntity(entity, dto);

            entity = repository.save(entity);

            return new DamageKindDTO(entity);
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

    private void copyDtoToEntity(DamageKind entity, DamageKindDTO dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }
}