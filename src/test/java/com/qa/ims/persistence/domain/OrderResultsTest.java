package com.qa.ims.persistence.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderResultsTest {

	@Test
    public void testConstructor() {
        OrderResults orderResults = new OrderResults(1L, "John", "Doe", 1L, 2L, "Pencil", 1L, 1.00F);

        assertEquals(new Long(1L), orderResults.getOrderId());
        assertEquals("John", orderResults.getFirstName());
        assertEquals("Doe", orderResults.getSurname());
        assertEquals(new Long(1L), orderResults.getCustomerId());
        assertEquals(new Long(2L), orderResults.getItemId());
        assertEquals("Pencil", orderResults.getItemName());
        assertEquals(new Long(1L), orderResults.getQuantity());
        assertEquals(new Float(1.00F), orderResults.getPrice());
    }

    @Test
    public void testSettersAndGetters() {
        OrderResults orderResults = new OrderResults(1L, "John", "Doe", 1L, 2L, "Pencil", 1L, 1.0F );
		orderResults.setOrderId(1L);
        orderResults.setFirstName("John");
        orderResults.setSurname("Doe");
        orderResults.setCustomerId(1L);
        orderResults.setItemId(2L);
        orderResults.setItemName("Pencil");
        orderResults.setQuantity(1L);
        orderResults.setPrice(1.00F);
		
        assertEquals(new Long(1L), orderResults.getOrderId());
        assertEquals("John", orderResults.getFirstName());
        assertEquals("Doe", orderResults.getSurname());
        assertEquals(new Long(1L), orderResults.getCustomerId());
        assertEquals(new Long(2L), orderResults.getItemId());
        assertEquals("Pencil", orderResults.getItemName());
        assertEquals(new Long(1L), orderResults.getQuantity());
        assertEquals(new Float(1.00F), orderResults.getPrice());
    }

    @Test
    public void testToString() {
        OrderResults orderResults = new OrderResults(1L, "John", "Doe", 1L, 2L, "Pencil", 1L, 1.00F);

        String expectedString = "order_id:1 first_name:John surname:Doe customer_id:1 item_id:2 item_name:Pencil quantity:1 price_per_item:1.0";
        assertEquals(expectedString, orderResults.toString());
    }

    @Test
    public void testHashCode() {
        OrderResults orderResults1 = new OrderResults(1L, "John", "Doe", 1L, 2L, "Pencil", 1L, 1.00F);
        OrderResults orderResults2 = new OrderResults(1L, "John", "Doe", 1L, 2L, "Pencil", 1L, 1.00F);

        assertEquals(orderResults1.hashCode(), orderResults2.hashCode());
    }

    @Test
    public void testEquals() {
        OrderResults orderResults1 = new OrderResults(1L, "John", "Doe", 1L, 2L, "Pencil", 1L, 1.00F);
        OrderResults orderResults2 = new OrderResults(1L, "John", "Doe", 1L, 2L, "Pencil", 1L, 1.00F);

        assertEquals(orderResults1, orderResults2);
    }
}
