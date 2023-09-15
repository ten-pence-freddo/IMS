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

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAO {

	public static final Logger LOGGER = LogManager.getLogger();


	public static OrdersItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Long quantity = resultSet.getLong("quantity");
		return new OrdersItems(orderId, itemId, quantity);
	}

	/**
	 * Reads all OrdersItems from the database
	 * 
	 * @return A list of OrdersItems
	 */

	public List<OrdersItems> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items");) {
			List<OrdersItems> OrdersItems = new ArrayList<>();
			while (resultSet.next()) {
				OrdersItems.add(modelFromResultSet(resultSet));
			}
			return OrdersItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public static OrdersItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a OrdersItems in the database
	 * 
	 * @param OrdersItems - takes in a OrdersItems object. id will be ignored
	 */

	public static OrdersItems create(OrdersItems OrdersItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(order_id, item_id, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, OrdersItems.getOrderId());
			statement.setLong(2, OrdersItems.getItemId());
            statement.setLong(3, OrdersItems.getQuantity());

			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public static OrdersItems read(Long orderId, Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders_items WHERE order_id = ? and item_id = ?");) {
			statement.setLong(1, orderId);
            statement.setLong(2, itemId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a OrdersItems in the database
	 * 
	 * @param OrdersItems - takes in a OrdersItems object, the id field will be used to
	 *                 update that OrdersItems in the database
	 * @return
	 */
	
	public static OrdersItems update(OrdersItems OrdersItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders_items SET quantity = ? WHERE order_id = ? AND item_id = ?");) {
			statement.setLong(1, OrdersItems.getQuantity());
			statement.setLong(2, OrdersItems.getOrderId());
			statement.setLong(3, OrdersItems.getItemId());
			statement.executeUpdate();
			return read(OrdersItems.getOrderId(), OrdersItems.getItemId() );
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a OrdersItems in the database
	 * 
	 * @param id - id of the OrdersItems
	 */
	
	public static int delete(long order_id, long item_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE order_id = ? and item_id = ?");) {
			statement.setLong(1, order_id);
            statement.setLong(2, item_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
