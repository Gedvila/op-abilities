package com.jpgedvila.opAbilities.services;

import com.jpgedvila.opAbilities.dtos.ElementDTO;
import com.jpgedvila.opAbilities.entities.Element;
import com.jpgedvila.opAbilities.repositories.ElementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElementService {

    private final ElementRepository repository;
    public ElementService(ElementRepository elementRepository){
        this.repository = elementRepository;
    }

    @Transactional(readOnly = true)
    public List<ElementDTO> findAll(){
        List<Element> elements = repository.findAll();

        return elements.stream().map(ElementDTO :: new).toList();
    }

    @Transactional(readOnly = true)
    public ElementDTO findById(Long id){

        Element element = repository.findById(id).orElseThrow();

        return new ElementDTO(element);
    }

    @Transactional(readOnly = true)
    public ElementDTO searchByName(String name){

        try {
            Element element = repository.searchByName(name);

            return new ElementDTO(element);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
