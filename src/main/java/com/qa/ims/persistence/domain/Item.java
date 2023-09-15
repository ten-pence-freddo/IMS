package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
    private String name;
	private Long stockQuantity;
	private Float price;


	public Item(String name, Long stockQuantity, Float price) {
		this.setName(name);
		this.setStockQuantity(stockQuantity);
        this.setPrice(price);
	}

    public Item(Long id, String name, Long stockQuantity, Float price) {
		this.setName(name);
		this.setStockQuantity(stockQuantity);
        this.setPrice(price);
        this.setId(id);
	}

	public Item(Long id) {
        this.setId(id);
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

    public Float getPrice() {
		return this.price;
	}

    public void setPrice(Float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "id:" + id + " name:" + name + " stock_quantity:" + stockQuantity + " price:" + price;
	}

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
	}

}

