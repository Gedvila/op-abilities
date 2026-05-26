package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.ParanormalPowerDTO;
import com.jpgedvila.opAbilities.entities.ParanormalPower;
import com.jpgedvila.opAbilities.repositories.ParanormalPowerRepository;
import com.jpgedvila.opAbilities.services.exceptions.DatabaseException;
import com.jpgedvila.opAbilities.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParanormalPowerService {

    private final ParanormalPowerRepository repository;

    public ParanormalPowerService(ParanormalPowerRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ParanormalPowerDTO> findAll(String name, Pageable pageable) {
        Page<ParanormalPower> result = repository.searchByName(name, pageable);

        return result.map(ParanormalPowerDTO::new);
    }

    @Transactional
    public ParanormalPowerDTO insert(ParanormalPowerDTO dto) {
        ParanormalPower entity = new ParanormalPower();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);

        return new ParanormalPowerDTO(entity);
    }

    @Transactional
    public ParanormalPowerDTO update(Long id, ParanormalPowerDTO dto) {
        try {

            ParanormalPower entity = repository.getReferenceById(id);
            copyDtoToEntity(entity, dto);

            entity = repository.save(entity);

            return new ParanormalPowerDTO(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Poder não encontrado");
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

    private void copyDtoToEntity(ParanormalPower entity, ParanormalPowerDTO dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrerequisite(dto.getPrerequisite());
        entity.setDescription(dto.getDescription());
        entity.setElement(dto.getElement());
    }
}
