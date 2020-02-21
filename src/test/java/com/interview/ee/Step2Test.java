package com.interview.ee;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Step2Test {
    @Test
    public void givenOneProductAndEmptyCart_whenAddMultipleTime_thenSameProductAndRightTotalReturn() {
        // testcase input
        String productSku = "dove-soap";
        String productName = "Dove Soap";
        BigDecimal productPrice = new BigDecimal(39.99);
        Integer orderQuantity = 5;

        // An empty shopping cart using simple cart payment calculator with 0 tax rate
        Cart shoppingCart = new Cart();
        PaymentCalculator calculator = new PaymentCalculator(new BigDecimal(0));
        // Product - Dove Soap with a unit price of $39.99
        Product product = new Product(productSku, productName, productPrice);

        //  adds 5 Dove Soaps to the shopping cart
        shoppingCart.addItem(product, orderQuantity);

        //  adds 3 Dove Soaps to the shopping cart
        shoppingCart.addItem(product, 3);

        // The shopping cart should contain 8 Dove Soaps
        assertEquals(0, Integer.valueOf(8).compareTo(shoppingCart.getProductQuantity(product)));
        // each with a unit price of $39.99
        // the shopping cart’s total price should equal $319.92
        assertEquals(0, BigDecimal.valueOf(319.92).compareTo(calculator.getPaymentAmount(shoppingCart.getItems())));
    }

}