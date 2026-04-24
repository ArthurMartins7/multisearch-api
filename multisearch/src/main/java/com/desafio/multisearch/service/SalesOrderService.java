package com.desafio.multisearch.service;

import com.desafio.multisearch.model.entity.SalesOrder;
import com.desafio.multisearch.model.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    public List<SalesOrder> findAll() {
        return this.salesOrderRepository.findAll();
    }
}
