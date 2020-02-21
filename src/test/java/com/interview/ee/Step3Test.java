package com.interview.ee;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class Step3Test {
    @Test
    public void givenMultipleProductsAndEmptyCart_whenAddMAllProducts_thenProductAndRightTotalReturn() {
        // Product - Dove Soap with a unit price of $39.99
        String doveSku = "dove-soap";
        String doveName = "Dove Soap";
        BigDecimal dovePriceInCents = new BigDecimal(39.99);
        Product productDove = new Product(doveSku, doveName, dovePriceInCents);

        // Product - Dove Soap with a unit price of $39.99
        String axeSku = "axe-deo";
        String axeName = "Axe Deo";
        BigDecimal axePriceInCents = new BigDecimal(99.99);
        Product productAxe = new Product(axeSku, axeName, axePriceInCents);

        // An empty shopping cart with sales tax rate of 12.5%
        BigDecimal taxRatePercent = new BigDecimal(12.5);
        PaymentCalculator calculator = new PaymentCalculator(taxRatePercent);
        Cart shoppingCart = new Cart();


        //  adds 2 Dove Soaps to the shopping cart
        Integer doveQuantity = 2;
        shoppingCart.addItem(productDove, doveQuantity);

        //  adds 3 Dove Soaps to the shopping cart
        Integer axeQuantity = 2;
        shoppingCart.addItem(productAxe, axeQuantity);

        //shopping cart should contain 2 Dove Soaps each with a unit price of 39.99
        assertEquals(doveQuantity, shoppingCart.getProductQuantity(productDove));

        // shopping cart should contain 2 Axe Deos each with a unit price of 99.99
        assertEquals(axeQuantity, shoppingCart.getProductQuantity(productAxe));

        // the total sales tax amount for the shopping cart should equal 35.00
        assertEquals(0, BigDecimal.valueOf(35).compareTo(calculator.getPaymentTaxAmount(shoppingCart.getItems())));
        assertEquals(0, BigDecimal.valueOf(279.96).compareTo(calculator.getPaymentAmountExcludeTax(shoppingCart.getItems())));
        // the shopping cart’s total price should equal 314.96
        assertEquals(0, BigDecimal.valueOf(314.96).compareTo(calculator.getPaymentAmount(shoppingCart.getItems())));

    }
}