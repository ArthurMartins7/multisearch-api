package com.desafio.multisearch.service;

import com.desafio.multisearch.model.entity.PurchaseOrder;
import com.desafio.multisearch.model.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public List<PurchaseOrder> findAll() {
        return this.purchaseOrderRepository.findAll();
    }
}
