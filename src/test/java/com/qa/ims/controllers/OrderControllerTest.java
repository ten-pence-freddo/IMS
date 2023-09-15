package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrdersItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.persistence.domain.OrderResults;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;
	private OrdersItemsDAO orders_items_dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long ID = 1L;
        final Long CUSTOMER_ID = 3L;
		final Order created = new Order(CUSTOMER_ID);
		final OrderResults orderResults = new OrderResults(ID, "Alex", "Furgeson", CUSTOMER_ID, 4L, "Playdough", 2L, 3.7F);

		Mockito.when(utils.getString()).thenReturn(Long.toString(CUSTOMER_ID), "4","2", "no");
		Mockito.when(dao.create(created)).thenReturn(orderResults);
		Mockito.when(dao.getLatestOrderId()).thenReturn(1L);

		assertEquals(orderResults, controller.create());

		Mockito.verify(utils, Mockito.times(4)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<OrderResults> OrderResults = new ArrayList<>();
		OrderResults.add(new OrderResults(10L, "Bart", "Simpson", 3L, 7L, "Archery Set", 4L, 12F));

        Mockito.when(utils.getString()).thenReturn("no");
		Mockito.when(dao.readAll()).thenReturn(OrderResults);

		assertEquals(OrderResults, controller.readAll());

        Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

 	@Test
	public void testUpdate() {
		OrderResults updated = new OrderResults(10L, "Bart", "Simpson", 3L, 7L, "Archery Set", 4L, 12F);

        Order orderInput = new Order(10L, 3L);
		Mockito.when(utils.getString()).thenReturn("10", "3", "no" );

		Mockito.when(this.dao.update(orderInput)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(utils, Mockito.times(3)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(orderInput);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
    

}
