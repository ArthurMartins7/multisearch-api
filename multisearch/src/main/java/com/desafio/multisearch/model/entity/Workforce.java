package com.desafio.multisearch.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Workforce {

    @JsonProperty("WorkforceID")
    private int WorkforceID;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Shift")
    private String shift;
}
