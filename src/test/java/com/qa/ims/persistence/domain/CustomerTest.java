package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import com.qa.ims.persistence.domain.Customer;

public class CustomerTest {

	@Test
    public void testHashCode() {
        Customer customer1 = new Customer("John", "Doe");
        Customer customer2 = new Customer("John", "Doe");
        assertEquals(customer1.hashCode(), customer2.hashCode());
    }

	@Test
    public void testEquals() {
        Customer customer1 = new Customer("John", "Doe");
        Customer customer2 = new Customer("John", "Doe");
		Customer nullCustomer = null;
		Customer nullFirstName = new Customer(null, "Doe");
		Customer nullId = new Customer(null,"John", "Doe");
		Customer notNullId = new Customer(1L,"John", "Doe");
		Customer nullSurname = new Customer("John", null);
		Customer diffSurname = new Customer("John", "Snow");
		Item notACustomer = new Item("Lego", 20L, 31.1F);

        assertEquals(true, customer1.equals(customer2));
		assertEquals(false, customer1.equals(nullCustomer));
		assertEquals(false, customer1.equals(nullFirstName));
		assertEquals(false, notNullId.equals(nullId));
		assertEquals(false, customer1.equals(nullSurname));
		assertEquals(false, customer1.equals(diffSurname));

		assertEquals(false, customer1.equals(nullCustomer));
		assertEquals(false, nullFirstName.equals(customer1));
		assertEquals(false, nullId.equals(notNullId));
		assertEquals(false, nullSurname.equals(customer1));
		assertEquals(false, customer1.equals(notACustomer));

    }



}
