package com.proj2.phonep1.controller;



import com.proj2.phonep1.service.FulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class FulfillmentController {
    private final FulfillmentService fulfillmentService;

    @Autowired
    public FulfillmentController(FulfillmentService fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    @PostMapping("/{productId}/{amount}")
    public void addInventory(@PathVariable String productId, @PathVariable int amount) {
        fulfillmentService.addInventory(productId, amount);
    }

    @DeleteMapping("/{productId}")
    public void removeInventory(@PathVariable String productId) {
        fulfillmentService.removeInventory(productId);
    }

    @GetMapping
    public String viewInventory() {
        return fulfillmentService.viewInventory();
    }
}
