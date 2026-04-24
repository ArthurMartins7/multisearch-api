package com.desafio.multisearch.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Equipment {

    @JsonProperty("EquipmentID")
    private String equipmentID;

    @JsonProperty("EquipmentName")
    private String equipmentName;
}