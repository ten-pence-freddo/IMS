package com.qa.ims.persistence.domain;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.Assert.assertEquals;

public class OrdersItemsTest {


	@Test
    public void testHashCode() {
        OrdersItems item1 = new OrdersItems(7L, 20L, 31L);
        OrdersItems item2 = new OrdersItems(7L, 20L, 31L);
        assertEquals(item1.hashCode(), item2.hashCode());
    }

	@Test
    public void testGetItemId() {
		OrdersItems ordersItems = new OrdersItems(3L, 2L, 30L);

        Long actual = ordersItems.getItemId();

        assertEquals(new Long(2L), actual);
    }

	@Test
    public void testGetQuantity() {
		OrdersItems ordersItems = new OrdersItems(3L, 2L, 30L);

        String actual = ordersItems.toString();

        assertEquals("Order Id:3 Item Id:2 Quantity:30", actual);
    }


	@Test
    public void testEquals() {
        OrdersItems item1 = new OrdersItems(7L, 20L, 31L);
        OrdersItems item2 = new OrdersItems(7L, 20L, 31L);
		OrdersItems nullOrdersItems = null;
		OrdersItems nullName = new OrdersItems(null, 20L, 31L);
		OrdersItems nullQuantity = new OrdersItems(7L, null, 31L);
		OrdersItems nullPrice = new OrdersItems (7L, 20L, null);
		OrdersItems diffName = new OrdersItems(31L, 20L, 31L);
		OrdersItems diffQuantity = new OrdersItems(7L, 21L, 31L);
		OrdersItems diffPrice = new OrdersItems(7L, 20L, 30L);
		Customer notAOrdersItems = new Customer("John", "Doe");

        assertEquals(true, item1.equals(item2));
		assertEquals(false, item1.equals(nullOrdersItems));
		assertEquals(false, item1.equals(nullName));
		assertEquals(false, item1.equals(nullQuantity));
		assertEquals(false, item1.equals(nullPrice));
	
		
		assertEquals(false, item1.equals(diffName));
		assertEquals(false, item1.equals(diffPrice));
		assertEquals(false, item1.equals(diffQuantity));
		
		
		
		assertEquals(true, item2.equals(item1));
		assertEquals(false, nullName.equals(item1));
		assertEquals(false, nullQuantity.equals(item1));
		assertEquals(false, nullPrice.equals(item1));



		assertEquals(false, item1.equals(notAOrdersItems));

    }

}
