package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrdersItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.persistence.domain.OrderResults;
import com.qa.ims.utils.Utils;

/**
 * Takes in Order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<OrderResults> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO OrderDAO;
	private Utils utils;

	public OrderController(OrderDAO OrderDAO, Utils utils) {
		super();
		this.OrderDAO = OrderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all Orders to the logger
	 */
	public List<OrderResults> readAll() {
		List<OrderResults> listOfOrders = OrderDAO.readAll();
		for (OrderResults order : listOfOrders) {
			LOGGER.info(order);
		}
		String ans;
		do{
			LOGGER.info("Would you like to get the cost of an order?");
			ans = utils.getString();
			ans.toLowerCase();
			if(ans.equals("yes")){
				calculateCostOfOrderId();
			}

		}while(!(ans.equals("yes")) && !(ans.equals("no")));

		return listOfOrders;
	}

	/**
	 * Creates a Order by taking in user input
	 */
	
	public OrderResults create() {
		LOGGER.info("Please enter customer id");
		Long customerId = Long.parseLong(utils.getString());
        String more = "yes";
		Order curOrder = new Order(customerId);
        OrderDAO.create(curOrder);
        while(more == "yes"){
            LOGGER.info("Please enter the item id");
    		Long itemId = Long.parseLong(utils.getString());
            LOGGER.info("Please enter the quantity");
		    Long quantity = Long.parseLong(utils.getString());
            LOGGER.info("Any more items (yes/no)?");
            more = "";
            while( more.equals("yes") == false && more.equals("no") == false ){
                more = utils.getString();
                more.toLowerCase();
            }
            /*get order id using sql */
			
           OrdersItemsDAO.create(new OrdersItems(OrderDAO.getLatestOrderId(), itemId, quantity));
        }

		 

		LOGGER.info("Order created");
		return null;
	}

	/**
	 * Updates an existing Order by taking in user input
	 */
	
	public OrderResults update() {
        LOGGER.info("Please enter the order id of the order you would like to update");
		Long orderId = Long.parseLong(utils.getString());
		LOGGER.info("Please enter customer id");
		Long customerId = Long.parseLong(utils.getString());
		
        String more = "yes";
        OrderDAO.update(new Order(orderId ,customerId));
		String addOrDeleteString;
		do{
		LOGGER.info("Do you want to add/delete items from this order? (add/delete/no)");
		addOrDeleteString = utils.getString();
		addOrDeleteString.toLowerCase();
		if(addOrDeleteString.equals("no")){
			break;
		}
		if(addOrDeleteString.equals("add")){
			while(more.equals("yes")){
            LOGGER.info("Please enter the item id");
    		Long itemId = Long.parseLong(utils.getString());
            LOGGER.info("Please enter the quantity");
		    Long quantity = Long.parseLong(utils.getString());
            LOGGER.info("Any more items (yes/no) to add?");
            more = "";
            while( more.equals("yes") == false && more.equals("no") == false ){
                more = utils.getString();
                more.toLowerCase();
            }
			OrdersItemsDAO.create(new OrdersItems(orderId, itemId, quantity));
		}
		}
		if(addOrDeleteString.equals("delete")){
			while(more.equals("yes")){
            LOGGER.info("Please enter the item id to delete");
    		Long itemId = Long.parseLong(utils.getString());
            LOGGER.info("Any more items to delete (yes/no)?");
            more = "";
            while( more.equals("yes") == false && more.equals("no") == false ){
                more = utils.getString();
                more.toLowerCase();
            }
			OrdersItemsDAO.delete(orderId, itemId);
		}
		}
		}while(!addOrDeleteString.equals("no") && !addOrDeleteString.equals("add") && !addOrDeleteString.equals("delete"));
		LOGGER.info("Order Updated");
		return null;
        }

	public void calculateCostOfOrderId(){
			LOGGER.info("Please enter the order id of the order you would like to calculate the cost for");
			Long orderId = Long.parseLong(utils.getString());

			LOGGER.info("The cost of order " + orderId + ": "+ OrderDAO.cost(orderId) );
		}


	/**
	 * Deletes an existing Order by the id of the Order
	 * 
	 * @return
	 */
	
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return OrderDAO.delete(id);
	}

}

