package com.desafio.multisearch.model.repository;

import com.desafio.multisearch.model.entity.SalesOrder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Repository
public class SalesOrderRepository {

    public List<SalesOrder> findAll() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = new ClassPathResource("data/sales_orders.json").getInputStream();

            return mapper.readValue(inputStream, new TypeReference<List<SalesOrder>>() {});

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler arquivo JSON", e);
        }
    }
}
