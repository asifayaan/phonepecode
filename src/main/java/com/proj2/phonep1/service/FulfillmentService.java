package com.proj2.phonep1.service;

public interface FulfillmentService {
    void addInventory(String productId, int amount);

    void removeInventory(String productId);

    String viewInventory();


}

