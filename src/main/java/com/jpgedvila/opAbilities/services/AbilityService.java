package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.AbilityDTO;
import com.jpgedvila.opAbilities.entities.Ability;
import com.jpgedvila.opAbilities.repositories.AbilityRepository;
import com.jpgedvila.opAbilities.services.exceptions.DatabaseException;
import com.jpgedvila.opAbilities.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbilityService {

    private final AbilityRepository repository;
    public AbilityService(AbilityRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<AbilityDTO> findAll(String name, Pageable pageable){
        Page<Ability> result = repository.searchByName(name,pageable);

        return result.map(AbilityDTO :: new);
    }

    @Transactional
    public AbilityDTO insert(AbilityDTO dto){
        Ability entity = new Ability();
        copyDtoToEntity(entity,dto);

        entity = repository.save(entity);

        return new AbilityDTO(entity);
    }

    @Transactional
    public AbilityDTO update(Long id, AbilityDTO dto){
        try {
            Ability entity = repository.getReferenceById(id);
            copyDtoToEntity(entity,dto);

            entity = repository.save(entity);

            return new AbilityDTO(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Habilidade não encontrada");
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

    private void copyDtoToEntity(Ability entity, AbilityDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrerequisite(dto.getPrerequisite());
        entity.setDescription(dto.getDescription());
        entity.setArchetype(dto.getArchetype());
    }
}
