package com.interview.ee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Serializable {
    // sku is unique to all products
    private String sku;
    private String name;
    private BigDecimal price;

    public Product(String sku, String name, BigDecimal price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getSku().equals(product.getSku()) &&
                getName().equals(product.getName()) &&
                getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSku(), getName(), getPrice());
    }
}
