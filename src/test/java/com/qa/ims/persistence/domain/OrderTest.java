package com.qa.ims.persistence.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Test
    public void testHashCode() {
        Order order1 = new Order(2L, 4L);
        Order order2 = new Order(2L, 4L);
        assertEquals(order1.hashCode(), order2.hashCode());
    }

	@Test
    public void testEquals() {
        Order order1 = new Order(2L, 4L);
        Order order2 = new Order(2L, 4L);
		Order nullOrder = null;
		Order nullFirstName = new Order(null, 4L);
	
		Order nullSurname = new Order(2L, null);
		Order diffSurname = new Order(2L, 5L);
		Item notAOrder = new Item("Lego", 20L, 31.1F);

        assertEquals(true, order1.equals(order2));
		assertEquals(false, order1.equals(nullOrder));
		assertEquals(false, order1.equals(nullFirstName));
	
		assertEquals(false, order1.equals(nullSurname));
		assertEquals(false, order1.equals(diffSurname));

		assertEquals(false, order1.equals(nullOrder));
		assertEquals(false, nullFirstName.equals(order1));
	
		assertEquals(false, nullSurname.equals(order1));
		assertEquals(false, order1.equals(notAOrder));

    }



}

