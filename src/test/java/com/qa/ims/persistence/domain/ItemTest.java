package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class ItemTest {

		@Test
    public void testHashCode() {
        Item item1 = new Item("Lego", 20L, 31.1F);
        Item item2 = new Item("Lego", 20L, 31.1F);
        assertEquals(item1.hashCode(), item2.hashCode());
    }

	@Test
    public void testEquals() {
        Item item1 = new Item("Lego", 20L, 31.1F);
        Item item2 = new Item("Lego", 20L, 31.1F);
		Item nullItem = null;
		Item nullName = new Item(null, 20L, 31.1F);
		Item nullId = new Item(null,"Lego", 20L, 31.1F);
		Item notNullId = new Item(1L,"Lego", 20L, 31.1F);
		Item nullQuantity = new Item("Lego", null, 31.1F);
		Item nullPrice = new Item ("Lego", 20L, null);
		Item diffName = new Item("Marbles", 20L, 31.1F);
		Item diffQuantity = new Item("Lego", 21L, 31.1F);
		Item diffPrice = new Item("Lego", 20L, 31F);
		Customer notAItem = new Customer("John", "Doe");

        assertEquals(true, item1.equals(item2));
		assertEquals(false, item1.equals(nullItem));
		assertEquals(false, item1.equals(nullName));
		assertEquals(false, item1.equals(nullQuantity));
		assertEquals(false, item1.equals(nullPrice));
		assertEquals(false, notNullId.equals(nullId));
		
		assertEquals(false, item1.equals(diffName));
		assertEquals(false, item1.equals(diffPrice));
		assertEquals(false, item1.equals(diffQuantity));
		
		
		
		assertEquals(true, item2.equals(item1));
		assertEquals(false, nullName.equals(item1));
		assertEquals(false, nullQuantity.equals(item1));
		assertEquals(false, nullPrice.equals(item1));
		assertEquals(false, nullId.equals(notNullId));



		assertEquals(false, item1.equals(notAItem));

    }

}

