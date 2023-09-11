package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in Item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO ItemDAO;
	private Utils utils;

	public ItemController(ItemDAO ItemDAO, Utils utils) {
		super();
		this.ItemDAO = ItemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all Items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> Items = ItemDAO.readAll();
		for (Item Item : Items) {
			LOGGER.info(Item);
		}
		return Items;
	}

	/**
	 * Creates a Item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter product name");
		String name = utils.getString();
		LOGGER.info("Please enter the quantity of items in stock");
		Long itemQuantity = Long.parseLong(utils.getString());
        LOGGER.info("Please enter the item price");
		Float price = Float.parseFloat(utils.getString());
		Item Item = ItemDAO.create(new Item(name, itemQuantity, price));
		LOGGER.info("Item created");
		return Item;
	}

	/**
	 * Updates an existing Item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the Item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a name");
		String name = utils.getString();
		LOGGER.info("Please enter the quantity of items in stock");
		Long itemQuantity = Long.parseLong(utils.getString());
        LOGGER.info("Please enter the item price");
		Float price = Float.parseFloat(utils.getString());
		Item Item = ItemDAO.update(new Item(id, name, itemQuantity, price));
		LOGGER.info("Item Updated");
		return Item;
	}

	/**
	 * Deletes an existing Item by the id of the Item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Item you would like to delete");
		Long id = utils.getLong();
		return ItemDAO.delete(id);
	}

}
