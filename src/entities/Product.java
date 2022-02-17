package entities;

public class Product{
	
	private String name;
	private Double unitPrice;
	private Integer quantity;
	
	public Product() {
		super();
	}

	public Product(String name, Double unitPrice, Integer quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public Double totalValue() {
		return unitPrice*quantity;
	}

	@Override
	public String toString() {
		return "Product [name = " + name + ", unitPrice = " + unitPrice + ", quantity = " + quantity + "]";
	}
	
	
}
