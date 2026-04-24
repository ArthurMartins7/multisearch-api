package com.desafio.multisearch.controller;

import com.desafio.multisearch.model.entity.Material;
import com.desafio.multisearch.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<Material> findAll() {
        return this.materialService.findAll();
    }
}
