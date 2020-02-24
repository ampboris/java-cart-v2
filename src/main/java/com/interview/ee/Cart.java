package com.interview.ee;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
    private Map<Product, Integer> items = new Hashtable<>();

    // list all items in cart
    public ImmutableMap<Product, Integer> getItems() {
        return ImmutableMap.copyOf(this.items);
    }

    public void addItem(Product product, Integer quantity) {
        if(product != null) {
            this.items.merge(product, quantity , (oldQuantity, newQuantity) -> oldQuantity + newQuantity);
        }
    }

    public Integer getProductQuantity(Product product) {
        return this.items.get(product);
    }
    public void removeItem(Product product) {
        this.items.remove(product);
    }
    public void emptyCart() {
        this.items.clear();
    }
}
