package com.desafio.multisearch.controller;

import com.desafio.multisearch.model.dto.MultiSearchResultDTO;
import com.desafio.multisearch.model.enums.Category;
import com.desafio.multisearch.service.MultiSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("filter")
public class MultiSearchController {

    @Autowired
    private  MultiSearchService multiSearchService;

    @GetMapping
    public Map<Category, List<MultiSearchResultDTO>> search(
            @RequestParam String query
    ) {
        return multiSearchService.multiSearch(query);
    }
}
