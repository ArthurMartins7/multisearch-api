package com.desafio.multisearch.model.repository;

import com.desafio.multisearch.model.entity.PurchaseOrder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Repository
public class PurchaseOrderRepository {


    public List<PurchaseOrder> findAll() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = new ClassPathResource("data/purchase_orders.json").getInputStream();

            return mapper.readValue(inputStream, new TypeReference<List<PurchaseOrder>>() {});

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler arquivo JSON", e);
        }
    }

}
