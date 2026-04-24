package com.desafio.multisearch.controller;

import com.desafio.multisearch.model.entity.Workforce;
import com.desafio.multisearch.service.WorkforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("workforce")
public class WorkforceController {

    @Autowired
    private WorkforceService workforceService;

    @GetMapping
    public List<Workforce> findAll() {
        return this.workforceService.findAll();
    }
}
