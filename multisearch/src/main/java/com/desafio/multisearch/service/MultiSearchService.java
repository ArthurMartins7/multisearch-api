package com.desafio.multisearch.service;

import com.desafio.multisearch.model.dto.CategoryGroupDTO;
import com.desafio.multisearch.model.dto.ItemDTO;
import com.desafio.multisearch.model.dto.MultiSearchResponseDTO;
import com.desafio.multisearch.model.enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MultiSearchService {

    private final EquipmentService equipmentService;
    private final MaterialService materialService;
    private final PurchaseOrderService purchaseOrderService;
    private final SalesOrderService salesOrderService;
    private final WorkforceService workforceService;

    public MultiSearchResponseDTO multiSearch(String query) {
        String q = query.toLowerCase();

        List<ItemDTO> allResults = Stream.of(
                        searchEquipments(q),
                        searchMaterials(q),
                        searchSalesOrders(q),
                        searchPurchaseOrders(q),
                        searchWorkforce(q)
                )
                .flatMap(List::stream)
                .toList();

        Map<Category, List<ItemDTO>> groupedItems = allResults.stream()
                .collect(Collectors.groupingBy(ItemDTO::category));

        Map<Category, CategoryGroupDTO> categoriesMap = new EnumMap<>(Category.class);

        for (Category cat : Category.values()) {
            List<ItemDTO> items = groupedItems.getOrDefault(cat, List.of());
            categoriesMap.put(cat, new CategoryGroupDTO(items.size(), items));
        }

        return new MultiSearchResponseDTO(allResults.size(), categoriesMap);
    }

    private List<ItemDTO> searchEquipments(String q) {
        return equipmentService.findAll().stream()
                .filter(e -> e.getEquipmentName().toLowerCase().contains(q))
                .map(e -> new ItemDTO(e.getEquipmentID(), e.getEquipmentName(), Category.EQUIPMENT, null))
                .toList();
    }

    private List<ItemDTO> searchMaterials(String q) {
        return materialService.findAll().stream()
                .filter(m -> m.getMaterialName().toLowerCase().contains(q))
                .map(m -> new ItemDTO(m.getMaterialID(), m.getMaterialName(), Category.MATERIAL, null))
                .toList();
    }

    private List<ItemDTO> searchSalesOrders(String q) {
        return salesOrderService.findAll().stream()
                .filter(s -> s.getCustomer().toLowerCase().contains(q) ||
                        s.getMaterialName().toLowerCase().contains(q))
                .map(s -> new ItemDTO(
                        String.valueOf(s.getSalesOrderID()),
                        s.getMaterialName(),
                        Category.SALES_ORDER,
                        s.getQuantity()
                ))
                .toList();
    }

    private List<ItemDTO> searchPurchaseOrders(String q) {
        return purchaseOrderService.findAll().stream()
                .filter(p -> p.getSupplier().toLowerCase().contains(q) ||
                        p.getMaterialName().toLowerCase().contains(q))
                .map(p -> new ItemDTO(
                        String.valueOf(p.getPurchaseOrderID()),
                        p.getMaterialName(),
                        Category.PURCHASE_ORDER,
                        p.getQuantity()
                ))
                .toList();
    }

    private List<ItemDTO> searchWorkforce(String q) {
        return workforceService.findAll().stream()
                .filter(w -> w.getName().toLowerCase().contains(q)
                        || w.getShift().toLowerCase().contains(q))
                .map(w -> new ItemDTO(
                        String.valueOf(w.getWorkforceID()),
                        w.getName(),
                        Category.WORKFORCE,
                        null
                ))
                .toList();
    }

}
