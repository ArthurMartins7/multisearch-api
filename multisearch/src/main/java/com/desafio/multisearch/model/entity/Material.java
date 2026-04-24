package com.desafio.multisearch.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Material {

    @JsonProperty("MaterialID")
    private String materialID;

    @JsonProperty("MaterialName")
    private String materialName;
}
