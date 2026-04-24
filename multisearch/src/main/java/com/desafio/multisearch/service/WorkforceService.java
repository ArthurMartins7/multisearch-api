package com.desafio.multisearch.service;

import com.desafio.multisearch.model.entity.Workforce;
import com.desafio.multisearch.model.repository.WorkforceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkforceService {

    @Autowired
    private WorkforceRepository workforceRepository;

    public List<Workforce> findAll() {
        return this.workforceRepository.findAll();
    }
}
