package com.interview.ee;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductTest {
    private String sku = "EE-2020";
    private String name = "java cart demo";
    private BigDecimal price = BigDecimal.valueOf(19.99);

    @Test
    public void givenProductDetails_whenCreateProduct_thenCorrectValuesReturn() {
        Product product = new Product(sku, name, price);

        assertNotNull(product);
        assertEquals(sku, product.getSku());
        assertEquals(name, product.getName());
        assertEquals(0, price.compareTo(product.getPrice()));
    }

    @Test
    public void givenTwoProductWithSameDetails_whenCompare_thenEqualTrueReturn() {
        Product product1 = new Product(sku, name, price);
        Product product2 = new Product(sku, name, price);

        assertTrue(product1.equals(product2));
    }

    @Test
    public void givenTwoProductWithDifferentDetails_whenCompare_thenEqualFalseReturn() {
        Product product1 = new Product(sku, name, price);

        assertFalse(product1.equals(null));
        assertFalse(product1.equals(new Integer(10)));
        assertFalse(product1.equals(new Product(sku, name, price.add(BigDecimal.valueOf(1)))));
        assertFalse(product1.equals(new Product(sku, name + "_1", price)));
        assertFalse(product1.equals(new Product(sku + "_1", name, price)));
    }
}