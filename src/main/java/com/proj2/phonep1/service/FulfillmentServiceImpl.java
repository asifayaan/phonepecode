package com.proj2.phonep1.service;


import com.proj2.phonep1.entity.InventoryItem;
import com.proj2.phonep1.repo.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FulfillmentServiceImpl implements FulfillmentService {
    private final InventoryItemRepository itemRepository;

    @Autowired
    public FulfillmentServiceImpl(InventoryItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void addInventory(String productId, int amount) {
        InventoryItem item = itemRepository.findByProductId(productId);
        if (item != null) {
            item.setAmount(item.getAmount() + amount);
        } else {
            item = new InventoryItem();
            item.setProductId(productId);
            item.setAmount(amount);
        }
        itemRepository.save(item);
    }

    @Override
    public void removeInventory(String productId) {
        InventoryItem item = itemRepository.findByProductId(productId);
        if (item != null) {
            int currentAmount = item.getAmount();
            if (currentAmount > 0) {
                item.setAmount(currentAmount - 1);
                itemRepository.save(item);
            } else {
                throw new RuntimeException("No inventory available for the specified product.");
            }
        } else {
            throw new RuntimeException("Product not found.");
        }
    }

    @Override
    public String viewInventory() {
        List<InventoryItem> items = itemRepository.findAll();
        StringBuilder inventory = new StringBuilder();
        for (InventoryItem item : items) {
            inventory.append("Product ID: ").append(item.getProductId()).append(", Amount: ").append(item.getAmount()).append("\n");
        }
        return inventory.toString();
    }


}
