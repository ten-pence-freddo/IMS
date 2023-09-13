package com.qa.ims.persistence.domain;

public class OrderResults {

    private Long orderId;
    private String firstName;
    private String surname;
    private Long customerId;
    private Long itemId;
    private String itemName;
    private Long quantity;

    
    public OrderResults(Long orderId, String firstName, String surname, Long customerId, Long itemId, String itemName, Long quantity ) {
		this.orderId = orderId;
        this.firstName = firstName;
        this.surname = surname;
        this.customerId = customerId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
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

	//@Override
	public String toString() {
		return "order_id:" + orderId + " first_name:" + firstName + " surname:" + surname + " customer_id:" + customerId + " item_id:" + itemId + " item_name:" + itemName + " quantity:" + quantity;
	}

  /* 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stockQuantity == null) ? 0 : stockQuantity.hashCode());
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
		Item other = (Item) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
        if (stockQuantity == null) {
			if (other.stockQuantity != null)
				return false;
		} else if (!stockQuantity.equals(other.stockQuantity))
			return false;
		return true;
	}*/

}
