package com.qa.ims.persistence.domain;

public class OrderResults {

    private Long orderId;
    private String firstName;
    private String surname;
    private Long customerId;
    private Long itemId;
    private String itemName;
    private Long quantity;
	private Float price;

    
    public OrderResults(Long orderId, String firstName, String surname, Long customerId, Long itemId, String itemName, Long quantity, Float price ) {
		this.orderId = orderId;
        this.firstName = firstName;
        this.surname = surname;
        this.customerId = customerId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
		this.price = price;
	}

  	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname (String surname) {
		this.surname = surname;
	}

  public Long getCustomerId() {
		return this.customerId;
	}

  public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

  public Long getItemId() {
		return this.itemId;
	}

  public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

  public String getItemName() {
		return this.itemName;
	}

  public void setItemName(String itemName) {
		this.itemName = itemName;
	}

  public Long getQuantity() {
		return this.quantity;
	}

  public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return this.price;
	}

  public void setPrice(Float price) {
		this.price = price;
	}

	//@Override
	public String toString() {
		return "order_id:" + orderId + " first_name:" + firstName + " surname:" + surname + " customer_id:" + customerId + " item_id:" + itemId + " item_name:" + itemName + " quantity:" + quantity + " price_per_item:" + price;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		OrderResults other = (OrderResults) obj;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!getFirstName().equals(other.getFirstName()))
			return false;
		if (getSurname() == null) {
			if (other.getSurname() != null)
				return false;
		} else if (!getSurname().equals(other.getSurname()))
			return false;
        if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.getCustomerId()))
			return false;
		 if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.getItemId()))
			return false;
		 if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (getQuantity() == null) {
			if (other.getQuantity() != null)
				return false;
		} else if (!getQuantity().equals(other.getQuantity()))
			return false;
		if (getPrice() == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.getPrice()))
			return false;
		return true;
	}

}
