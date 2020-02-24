package com.interview.ee;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    private Cart cart = new Cart();
    private Product testProduct1 = new Product("test-1", "test product 1", BigDecimal.valueOf(19.99));
    private Product testProduct2 = new Product("test-2", "test product 2", BigDecimal.valueOf(3));
    private Product testProduct3 = new Product("test-3", "test product 3", BigDecimal.valueOf(113.00));

    @Test
    public void givenNewProductItem_whenAdd_thenCorrectItemReturn() {
        cart.emptyCart();
        assertEquals("cart is NOT empty",0, cart.getItems().size());
        cart.addItem(testProduct1, 3);
        assertEquals(1, cart.getItems().size());
        assertEquals(0, Integer.valueOf(3).compareTo(cart.getProductQuantity(testProduct1)));
    }

    @Test
    public void givenNullProduct_whenAdd_thenNothingChangeAndNoExceptionReturn() {
        cart.emptyCart();
        assertEquals("cart is NOT empty",0, cart.getItems().size());
        cart.addItem(null, 3);
        assertEquals(0, cart.getItems().size());
    }

    @Test
    public void givenUpdatedProductItem_whenAdd_thenUpdatedItemReturn() {
        cart.emptyCart();
        assertEquals("cart is NOT empty",0, cart.getItems().size());
        cart.addItem(testProduct1, 3);
        assertEquals("cart has NO or More than 1 item",1, cart.getItems().size());
        assertEquals(0,Integer.valueOf(3).compareTo(cart.getProductQuantity(testProduct1)));

        cart.addItem(testProduct1, 7);
        assertEquals("cart has NO or More than 1 item",1, cart.getItems().size());
        assertEquals(0,Integer.valueOf(10).compareTo(cart.getProductQuantity(testProduct1)));
    }

    @Test
    public void givenProductNotInCart_whenRemove_thenItemsStillThere() {
        cart.emptyCart();
        cart.addItem(testProduct1, 1);
        cart.addItem(testProduct2, 1);
        cart.addItem(testProduct3, 3);
        assertEquals(3, cart.getItems().size());
        cart.removeItem(testProduct2);
        assertEquals(2, cart.getItems().size());
    }

    @Test
    public void givenNotEmptyCart_whenEmptyCart_thenNoItemReturn() {
        cart.addItem(testProduct1, 1);
        assertTrue("cart is empty", cart.getItems().size() > 0);
        cart.emptyCart();
        assertTrue("cart is NOT empty after empty cart", cart.getItems().size() == 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void givenCartHasItems_whenEmptyCartViaGetItem_thenNonSupportExceptionReturn() {
        cart.emptyCart();
        cart.addItem(testProduct1, 1);
        cart.addItem(testProduct2, 1);
        assertEquals(2, cart.getItems().size());
        cart.getItems().putIfAbsent(testProduct3, 3);
    }
    @Test
    public void givenCartHasItems_whenGetItem_thenProductShouldBeTheSame() {
        cart.emptyCart();
        cart.addItem(testProduct1, 1);
        assertEquals(1, cart.getItems().size());
        assertEquals(0, Integer.valueOf(1).compareTo(cart.getItems().entrySet().asList().get(0).getValue()));
        assertTrue(testProduct1.equals(cart.getItems().entrySet().asList().get(0).getKey()));
    }
}
