package com.desafio.multisearch.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SalesOrder {

    @JsonProperty("SalesOrderID")
    private int salesOrderID;

    @JsonProperty("DeliveryDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate deliveryDate;

    @JsonProperty("Customer")
    private String customer;

    @JsonProperty("MaterialID")
    private String materialID;

    @JsonProperty("MaterialName")
    private String materialName;

    @JsonProperty("Quantity")
    private int quantity;

    @JsonProperty("TotalValue")
    private int totalValue;
}
