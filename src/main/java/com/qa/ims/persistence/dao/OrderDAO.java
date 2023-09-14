package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderResults;
import com.qa.ims.utils.DBUtils;

public class OrderDAO {

	public static final Logger LOGGER = LogManager.getLogger();

	
	public OrderResults modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String firstName = resultSet.getString("first_name");
        String surname = resultSet.getString("surname");
        Long customerId = resultSet.getLong("customer_id");
        Long itemId = resultSet.getLong("item_id");
        String itemName = resultSet.getString("name");
        Long quantity = resultSet.getLong("quantity");

		return new OrderResults(id, firstName, surname, customerId, itemId, itemName, quantity);
	}

	/**
	 * Reads all Order from the database
	 * 
	 * @return A list of Order
	 */
	
	public List<OrderResults> readAll() { /*just ensure that this reads across multiple tables*/
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = 
                statement.executeQuery("SELECT orders.id, customers.first_name, customers.surname, orders.customer_id, orders_items.item_id, item.name, orders_items.quantity FROM customers, item, orders, orders_items where orders.id = orders_items.order_id and customers.id = orders.customer_id and orders_items.item_id = item.id");) {
			List<OrderResults> Order = new ArrayList<>();
			while (resultSet.next()) {
				Order.add(modelFromResultSet(resultSet));
			}
			return Order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<OrderResults>();
	}

	public OrderResults readLatest() { /*just ensure that this reads across multiple tables*/
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orders.id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a Order in the database
	 * 
	 * @param Order - takes in a Order object. id will be ignored
	 */
	
	public void create(Order Order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customer_id) VALUES (?)");) {
			statement.setLong(1, Order.getCustomerId());

			statement.executeUpdate();
			//return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		//return null;
	}

	
	public void read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				//return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		//return null;
	}

	/**
	 * Updates a Order in the database
	 * 
	 * @param Order - takes in a Order object, the id field will be used to
	 *                 update that Order in the database
	 * @return
	 */

	public void update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET customer_id = ? WHERE id = ?");) {
			statement.setLong(1, order.getCustomerId());
			statement.setLong(2, order.getId());
			statement.executeUpdate();
			//return read(order.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		//return null;
	}

	/**
	 * Deletes a Order in the database
	 * 
	 * @param id - id of the Order
	 */
	
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE order_id = ?");) {
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return 0;
	}

	public Float cost(Long orderId){
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement =
               connection.prepareStatement("SELECT sum(item.price) FROM item, orders, orders_items where orders.id = orders_items.order_id and orders_items.item_id = item.id and orders.id = ?");) {
					statement.setLong(1, orderId);

			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return resultSet.getFloat(1);
			}
			
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Long getLatestOrderId(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("select id FROM orders order by id desc limit 1");) {
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				Long res = resultSet.getLong(1);
				return res;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
}
