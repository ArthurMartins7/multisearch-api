package com.desafio.multisearch.controller;

import com.desafio.multisearch.model.entity.SalesOrder;
import com.desafio.multisearch.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("salesorder")
public class SalesOrderController {

    @Autowired
    private SalesOrderService salesOrderService;

    @GetMapping
    public List<SalesOrder> findAll() {
        return this.salesOrderService.findAll();
    }
}
