package com.desafio.multisearch.service;

import com.desafio.multisearch.model.entity.Equipment;
import com.desafio.multisearch.model.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> findAll() {
        return this.equipmentRepository.findAll();
    }
}
