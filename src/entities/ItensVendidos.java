package entities;

public class ItensVendidos {
	
	Product product;
	
	public ItensVendidos() {		
	}

	public ItensVendidos(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}	
	
	public Double fullPrice() {
		return product.getQuantity() * product.getUnitPrice();
	}
}
