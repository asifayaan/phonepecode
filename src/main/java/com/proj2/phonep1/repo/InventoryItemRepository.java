package com.proj2.phonep1.repo;


import com.proj2.phonep1.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    InventoryItem findByProductId(String productId);
}
