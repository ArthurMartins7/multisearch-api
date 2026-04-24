package com.desafio.multisearch.service;

import com.desafio.multisearch.model.dto.MultiSearchResultDTO;
import com.desafio.multisearch.model.enums.Category;
import com.desafio.multisearch.model.selector.MultiSearchSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MultiSearchService {

    @Autowired
    private  MultiSearchSelector multiSearchSelector;

    public Map<Category, List<MultiSearchResultDTO>> multiSearch(String query) {
        return this.multiSearchSelector.multiSearch(query);
    }
}
