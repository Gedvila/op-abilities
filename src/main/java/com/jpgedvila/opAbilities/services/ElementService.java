package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.ElementDTO;
import com.jpgedvila.opAbilities.entities.Element;
import com.jpgedvila.opAbilities.repositories.ElementRepository;
import com.jpgedvila.opAbilities.services.exceptions.DatabaseException;
import com.jpgedvila.opAbilities.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElementService {

    private final ElementRepository repository;

    public ElementService(ElementRepository elementRepository) {
        this.repository = elementRepository;
    }

    @Transactional(readOnly = true)
    public List<ElementDTO> findAll() {
        List<Element> elements = repository.findAll();

        return elements.stream().map(ElementDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ElementDTO findById(Long id) {

        Element element = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );

        return new ElementDTO(element);
    }

    @Transactional(readOnly = true)
    public ElementDTO searchByName(String name) {

        try {
            Element element = repository.searchByName(name);

            return new ElementDTO(element);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public ElementDTO insert(ElementDTO dto) {
        Element entity = new Element();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);

        return new ElementDTO(entity);
    }

    @Transactional
    public ElementDTO update(Long id, ElementDTO dto) {

        try {

            Element entity = repository.getReferenceById(id);
            copyDtoToEntity(entity, dto);

            entity = repository.save(entity);

            return new ElementDTO(entity);
        } catch (RuntimeException e) {
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

    private void copyDtoToEntity(Element entity, ElementDTO dto) {
        entity.setName(dto.getName());
    }
}
