package com.desafio.multisearch.model.dto;

import com.desafio.multisearch.model.enums.Category;

import java.util.Map;

public record MultiSearchResponseDTO(long totalQuantity,
                                     Map<Category, CategoryGroupDTO> categories) {
}
