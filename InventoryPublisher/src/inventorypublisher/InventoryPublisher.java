package inventorypublisher;

public interface InventoryPublisher {
	public String publishService();
	public void InventoryServices();
	public void addProduct(Product product);
	public void deleteProduct(Product productId);
	public void ViewProduct();
	public Double getTotalCost();
	public void filterProduct(String filterName);
	
	
	
}
