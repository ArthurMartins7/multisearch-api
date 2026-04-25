package com.desafio.multisearch.model.dto;

import java.util.List;

public record CategoryGroupDTO(long categoryQuantity,
                               List<ItemDTO> items) {
}
