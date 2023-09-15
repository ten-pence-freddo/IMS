package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");

	}

	@Test
	public void testCreate() {
		final Order created = new Order(10L, 1L);
		assertEquals(created, DAO.create(created));
	}

	/*@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order("Train Set", 10L, 14.7F));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
        Order testOrder = new Order(1L);
		//assertEquals(new Order("Train Set", 10L, 14.7F), DAO.readLatest());
        assertEquals(testOrder, new Order(1L));
        assertEquals(testOrder, DAO.readLatest());
        
    }

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order("Train Set", 10L, 14.7F), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order("Train Set", 10L, 14.7F);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}*/
}

