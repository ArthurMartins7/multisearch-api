package com.desafio.multisearch.model.dto;

import com.desafio.multisearch.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MultiSearchResultDTO {

    private String id;
    private String description;
    private Category category;

}
