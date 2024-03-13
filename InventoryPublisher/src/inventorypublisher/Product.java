package inventorypublisher;

public class Product {
	
	private String id;
	private String productName;
	private String paymentType;
	private int quantity;
	private  Double price;
 
	
	
	
	
	
	public Product(String id, String productName, String paymentType, int quantity, Double price) {
	 
		this.id = id;
		this.productName = productName;
		this.paymentType = paymentType;
		this.quantity = quantity;
		this.price = price;
		 
	}
	
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getProductName() {
		return productName;
	}
	
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public String getPaymentType() {
		return paymentType;
	}
	
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public Double getPrice() {
		return price;
	}
	
	
	public void setPrice(Double price) {
		this.price = price;
	}
 
	
	

}
