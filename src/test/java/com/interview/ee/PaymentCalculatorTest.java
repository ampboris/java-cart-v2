package com.interview.ee;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PaymentCalculatorTest {

    private BigDecimal taxRatePct = BigDecimal.valueOf(10.5);
    private PaymentCalculator calculator = new PaymentCalculator(taxRatePct);

    @Test
    public void givenCalculator_whenGetRate_thenValidRateReturn() {
        assertEquals(0, taxRatePct.compareTo(calculator.getTaxRatePercent()));
    }

    @Test
    public void givenEmptyItems_whenGetTotal_thenValidAmountReturn() {
        Map<Product, Integer> items = new Hashtable<>();
        assertEquals(0, BigDecimal.valueOf(0).compareTo(calculator.getPaymentAmount(items)));
    }
    @Test
    public void givenNullList_whenGetTotal_thenValidAmountReturn() {
        assertEquals(0, BigDecimal.valueOf(0).compareTo(calculator.getPaymentAmount(null)));
    }

    @Test
    public void givenItemsRoundingRequired_whenGetTotal_thenValidAmountReturn() {
        Map<Product, Integer> items = new Hashtable<>();

        Product testProduct = new Product("test-1", "test product 1", BigDecimal.valueOf(0.03));
        // 3 * 1.105 = 3.315 => 3
        items.put(testProduct, 1);
        assertEquals(0, BigDecimal.valueOf(0.03).compareTo(calculator.getPaymentAmount(items)));

        // 5 * 1.105 = 5.525 => 6
        testProduct = new Product("test-1", "test product 1", BigDecimal.valueOf(0.05));
        items.clear();
        items.put(testProduct, 1);
        assertEquals(0, BigDecimal.valueOf(0.06).compareTo(calculator.getPaymentAmount(items)));

        // 6 * 1.105 = 6.63 => 7
        testProduct = new Product("test-1", "test product 1", BigDecimal.valueOf(0.06));
        items.clear();
        items.put(testProduct, 1);
        assertEquals(0, BigDecimal.valueOf(0.07).compareTo(calculator.getPaymentAmount(items)));
    }

    @Test
    public void givenMultipleItems_whenGetTotal_thenValidAmountReturn() {
        Map<Product, Integer> items = new Hashtable<>();

        Product testProduct1 = new Product("test-1", "test product 1", BigDecimal.valueOf(0.02));
        Product testProduct2 = new Product("test-2", "test product 1", BigDecimal.valueOf(0.05));
        Product testProduct3 = new Product("test-3", "test product 1", BigDecimal.valueOf(0.07));

        // 1 * 2 = 2
        items.put(testProduct1, 1);
        // 5 * 2 = 10
        items.put(testProduct2, 2);
        // 7 * 3 = 21
        items.put(testProduct3, 3);


        //Total without tax = 33, with tax = 33 * 1.105 = 36.465 => 36
        assertEquals(0, BigDecimal.valueOf(0.03).compareTo(calculator.getPaymentTaxAmount(items)));
        assertEquals(0, BigDecimal.valueOf(0.33).compareTo(calculator.getPaymentAmountExcludeTax(items)));
        assertEquals(0, BigDecimal.valueOf(0.36).compareTo(calculator.getPaymentAmount(items)));
    }
}