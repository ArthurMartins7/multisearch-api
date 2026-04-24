package com.desafio.multisearch.controller;

import com.desafio.multisearch.model.entity.Equipment;
import com.desafio.multisearch.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> findAll() {
        return this.equipmentService.findAll();
    }
}
