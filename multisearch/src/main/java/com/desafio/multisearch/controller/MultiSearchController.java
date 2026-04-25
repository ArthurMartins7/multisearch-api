package com.desafio.multisearch.controller;

import com.desafio.multisearch.model.dto.MultiSearchResponseDTO;
import com.desafio.multisearch.service.MultiSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filter")
public class MultiSearchController {

    @Autowired
    private  MultiSearchService multiSearchService;

    @GetMapping
    public ResponseEntity<MultiSearchResponseDTO> multiSearch(@RequestParam String query) {
        MultiSearchResponseDTO response = multiSearchService.multiSearch(query);

        return ResponseEntity.ok(response);
    }
}
