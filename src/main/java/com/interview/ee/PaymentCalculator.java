package com.interview.ee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class PaymentCalculator {
    private BigDecimal taxRatePercent;

    public PaymentCalculator(BigDecimal taxRatePercent) {
        this.taxRatePercent = taxRatePercent;
    }

    public BigDecimal getTaxRatePercent() {
        return this.taxRatePercent;
    }

    public BigDecimal getPaymentTaxAmount(Map<Product, Integer> items) {
        BigDecimal serviceTax = this.getPaymentAmountExcludeTax(items).multiply(this.taxRatePercent.divide(BigDecimal.valueOf(100)));
        return serviceTax.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPaymentAmount(Map<Product, Integer> items) {
        return this.getPaymentAmountExcludeTax(items).add(this.getPaymentTaxAmount(items)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPaymentAmountExcludeTax(Map<Product, Integer> items) {
        BigDecimal total =  items == null ? BigDecimal.valueOf(0) : items.entrySet().stream()
                .map(x -> x.getKey().getPrice().multiply(BigDecimal.valueOf(x.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
