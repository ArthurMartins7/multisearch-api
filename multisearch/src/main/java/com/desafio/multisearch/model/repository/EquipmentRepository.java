package com.desafio.multisearch.model.repository;

import com.desafio.multisearch.model.entity.Equipment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Repository
public class EquipmentRepository {

    public List<Equipment> findAll() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = new ClassPathResource("data/equipments.json").getInputStream();

            return mapper.readValue(inputStream, new TypeReference<List<Equipment>>() {});

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler arquivo JSON", e);
        }
    }
}
