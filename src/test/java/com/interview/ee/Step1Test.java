package com.interview.ee;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Step1Test {
    @Test
    public void givenOneProductAndEmptyCart_whenAdd_thenSameProductAndRightTotalReturn() {
        // testcase input
        String productSku = "dove-soap";
        String productName = "Dove Soap";
        BigDecimal productPrice = new BigDecimal(39.99);
        Integer orderQuantity = 5;

        // An empty shopping cart using simple pricing calculator
        Cart shoppingCart = new Cart();
        PaymentCalculator calculator = new PaymentCalculator(new BigDecimal(0));
        // Product - Dove Soap with a unit price of $39.99
        Product product = new Product(productSku, productName, productPrice);

        //  adds 5 Dove Soaps to the shopping cart
        shoppingCart.addItem(product, orderQuantity);
        // The shopping cart should contain 5 Dove Soaps
        assertEquals(orderQuantity, shoppingCart.getProductQuantity(product));
//        // each with a unit price of $39.99
//        assertEquals(productPrice, shoppingCart.getItems().keySet().);
//        assertTrue(product.equals(item.getProduct()));
        // the shopping cart’s total price should equal $199.95
        assertEquals(0, BigDecimal.valueOf(199.95).compareTo(calculator.getPaymentAmount(shoppingCart.getItems())));
    }

}