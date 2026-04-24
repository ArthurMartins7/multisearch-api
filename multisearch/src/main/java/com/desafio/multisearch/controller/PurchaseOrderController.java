package com.desafio.multisearch.controller;

import com.desafio.multisearch.model.entity.PurchaseOrder;
import com.desafio.multisearch.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("purchaseorder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping
    public List<PurchaseOrder> findAll() {
        return this.purchaseOrderService.findAll();
    }
}
