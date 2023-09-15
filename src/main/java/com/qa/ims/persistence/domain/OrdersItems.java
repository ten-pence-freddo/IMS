package com.qa.ims.persistence.domain;

public class OrdersItems {

	private Long orderId;
    private Long itemId;
	private Long quantity;

	public OrdersItems(Long orderId, Long itemId, Long quantity) {
		this.setOrderId(orderId);
		this.setItemId(itemId);
        this.setQuantity(quantity);
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long id) {
		this.orderId = id;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Order Id:" + orderId + " Item Id:" + itemId + " Quantity:" + quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersItems other = (OrdersItems) obj;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

}
