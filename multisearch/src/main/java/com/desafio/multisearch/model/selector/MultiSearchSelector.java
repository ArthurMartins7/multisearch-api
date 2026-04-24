package com.desafio.multisearch.model.selector;

import com.desafio.multisearch.model.dto.MultiSearchResultDTO;
import com.desafio.multisearch.model.enums.Category;
import com.desafio.multisearch.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MultiSearchSelector {

    private final EquipmentService equipmentService;
    private final MaterialService materialService;
    private final PurchaseOrderService purchaseOrderService;
    private final SalesOrderService salesOrderService;
    private final WorkforceService workforceService;

    public Map<Category, List<MultiSearchResultDTO>> multiSearch(String query) {

        String q = query.toLowerCase();
        List<MultiSearchResultDTO> results = new ArrayList<>();

        equipmentService.findAll().stream()
                .filter(e -> e.getEquipmentName().toLowerCase().contains(q))
                .forEach(e -> results.add(
                        new MultiSearchResultDTO(
                                e.getEquipmentID(),
                                e.getEquipmentName(),
                                Category.EQUIPMENT
                        )
                ));

        materialService.findAll().stream()
                .filter(m -> m.getMaterialName().toLowerCase().contains(q))
                .forEach(m -> results.add(
                        new MultiSearchResultDTO(
                                m.getMaterialID(),
                                m.getMaterialName(),
                                Category.MATERIAL
                        )
                ));

        salesOrderService.findAll().stream()
                .filter(s -> s.getCustomer().toLowerCase().contains(q)
                        || s.getMaterialName().toLowerCase().contains(q))
                .forEach(s -> results.add(
                        new MultiSearchResultDTO(
                                String.valueOf(s.getSalesOrderID()),
                                s.getCustomer() + " - " + s.getMaterialName(),
                                Category.SALES_ORDER
                        )
                ));

        purchaseOrderService.findAll().stream()
                .filter(p -> p.getSupplier().toLowerCase().contains(q))
                .forEach(p -> results.add(
                        new MultiSearchResultDTO(
                                String.valueOf(p.getPurchaseOrderID()),
                                p.getSupplier(),
                                Category.PURCHASE_ORDER
                        )
                ));

        workforceService.findAll().stream()
                .filter(w -> w.getName().toLowerCase().contains(q))
                .forEach(w -> results.add(
                        new MultiSearchResultDTO(
                                String.valueOf(w.getWorkforceID()),
                                w.getName(),
                                Category.WORKFORCE
                        )
                ));

        return results.stream()
                .collect(Collectors.groupingBy(MultiSearchResultDTO::getCategory));
    }
}
