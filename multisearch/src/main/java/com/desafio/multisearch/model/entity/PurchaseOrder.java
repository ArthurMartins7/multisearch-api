package com.desafio.multisearch.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseOrder {

    @JsonProperty("PurchaseOrderID")
    private int purchaseOrderID;

    @JsonProperty("DeliveryDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate deliveryDate;

    @JsonProperty("Supplier")
    private String supplier;

    @JsonProperty("MaterialID")
    private String materialID;

    @JsonProperty("MaterialName")
    private String materialName;

    @JsonProperty("Quantity")
    private int quantity;

    @JsonProperty("TotalCost")
    private int totalCost;



}
