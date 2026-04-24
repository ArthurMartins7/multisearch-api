package com.desafio.multisearch.service;

import com.desafio.multisearch.model.entity.Material;
import com.desafio.multisearch.model.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> findAll() {
        return this.materialRepository.findAll();
    }
}
