package com.desafio.multisearch.model.dto;

import com.desafio.multisearch.model.enums.Category;

public record ItemDTO(String id,
                      String description,
                      Category category,
                      Integer individualQuantity) {

}
