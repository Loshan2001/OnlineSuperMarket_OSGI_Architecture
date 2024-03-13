package inventorypublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventorypublisherImpl implements InventoryPublisher{
	private Map<String,Product> inventory;
    private Double totalCost;
    
    public InventorypublisherImpl() {
    	inventory = new HashMap<>();
    	totalCost=0.0;
    	
    	
   	 Product product2 = new Product("1011","Shampoo","card",12,130.00);
	 inventory.put(product2.getId(), product2);
	 totalCost = totalCost + (product2.getPrice()* product2.getQuantity());
	 
	 Product product3 = new Product("1012","apple","cash",10,100.00);
	 inventory.put(product3.getId(), product3);
	 totalCost = totalCost + (product3.getPrice()* product3.getQuantity());
	 
	 Product product4 = new Product("1013","mango","card",12,100.00);
	 inventory.put(product4.getId(), product4);
	 totalCost = totalCost + (product4.getPrice()* product4.getQuantity());
	 
	 Product product5 = new Product("1014","apple","card",40,50.00);
	 inventory.put(product5.getId(), product5);
	 totalCost = totalCost + (product5.getPrice()* product5.getQuantity());
    }
	@Override
	public String publishService() {
		
		return "Execute the publish service of InventoryPublisher";
	}

	@Override
	public void addProduct(Product product) {
 
	

		 
		 Scanner scn = new  Scanner(System.in);
		 System.out.println("Enter the product ID ");
		 String pid = scn.next();
		 System.out.println("Enter the product Name ");
		 String pName = scn.next();
		 System.out.println("Enter the Payment type(card/cash) ");
		 System.out.println("1-> card ");
		 System.out.println("2-> cash ");
		 int pTypes = scn.nextInt();
		 String pType = "card";
		 switch(pTypes) {
		 	case 1 : 
		 		pType = "card" ;
		 		System.out.println("Card payment");
		 		break;
		 	case 2 : 
		 		pType = "cash" ;
		 		System.out.println("Cash payment");
		 		break;
		 	default : 
		 		System.out.println("Invalid payment type. try again!!!");
		 		pTypes = scn.nextInt();
		 }
		 System.out.println("Enter the Quantity ");
		 int qty = scn.nextInt();
		 System.out.println("Enter the product price ");
		 Double price = scn.nextDouble();
		
 
		 
		 Product product1 = new Product(pid,pName,pType,qty,price);
		 inventory.put(product1.getId(),product1);
		 totalCost =  totalCost + (product1.getPrice()* product1.getQuantity());
		 System.out.println("Successfully updated");
		 InventoryServices();
		 
	}

	 

	@Override
	public void deleteProduct(Product productId) {
		 Scanner scn = new  Scanner(System.in);
		 System.out.println("Enter the product ID ");
		 String pId = scn.next(); 
		if (inventory.containsKey(pId)) {
            Product product = inventory.remove(pId);
            totalCost -= product.getPrice() * product.getQuantity();
            System.out.println("successfully deleted");
           
        }
		 InventoryServices();
		 System.out.println(); 
		 
	}

	@Override
	public Double getTotalCost() {
		 
		return totalCost;
	}
	@Override
	public void InventoryServices() {
		
		 System.out.println(); 
		 System.out.println(); 
		 System.out.println("Welcome to the Inventory Management");
		 System.out.println(); 
		 
		 
		 Scanner scn = new  Scanner(System.in);
		 System.out.println("Select the option : ");
		 System.out.println("1. Add Product");
		 System.out.println("2. Delete Product");
		 System.out.println("3. get total Inventory Amount");
		 System.out.println("4. view all product");
		 System.out.println("5. filter product by name");
		 System.out.println("6. Exit"); 
		 
		 
		 
		 System.out.println(); 
		  
		 System.out.println(); 
		 int option = scn.nextInt();
		 
		 while(option != 6 ) {
			 if(option == 1) {
				  addProduct(null);
			 }
			 else if(option == 2) {
				  deleteProduct(null);
			 }
			 else if(option == 3) {
				 Double total =  getTotalCost();
				 System.out.println("Total Inventory Amount : "+ total);
				 InventoryServices();
			 }
			 else if(option == 4) {
				 ViewProduct();
			 }
			 else if(option == 5) {
				 filterProduct(null);
			 }
			 else {
				 System.out.println("oops! Enter the correct option :");
			 }
			 option = scn.nextInt();
		 }
		 System.out.println("Thank you");
		
	}
	@Override
	public void ViewProduct() {
		 System.out.println(); 
		 System.out.println("==================================================================================="); 
		 System.out.println(); 
		 
		 System.out.println("Listing All Product");
		 System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n ",
	                "Product ID", "Product Name", "Type", "Quantity", "Price");

	       
 
	        for (Product product : inventory.values()) {
	            System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f\n ",
	                    product.getId(), product.getProductName(), product.getPaymentType(),
	                    product.getQuantity(), product.getPrice());
	        }
	        
	      System.out.println(); 
	      System.out.println("==================================================================================="); 
	      System.out.println(); 
	      InventoryServices();
		
	}
	
	public void filterProduct(String filterName) {
		
		
		 
		 Scanner scn = new  Scanner(System.in);
		 System.out.println("Select the product Name : ");
		 String filter = scn.next();
		 
		 System.out.println(); 
		 System.out.println("==================================================================================="); 
		 System.out.println(); 
		 
	    System.out.println("Listing Filter Products");

	    System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n",
	            "Product ID", "Product Name", "Type", "Quantity", "Price");

	    for (Product product : inventory.values()) {
	        if (product.getProductName().equalsIgnoreCase(filter)) {
	            System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f\n",
	                    product.getId(), product.getProductName(), product.getPaymentType(),
	                    product.getQuantity(), product.getPrice());
	        }
	    }
	     System.out.println(); 
		 System.out.println("==================================================================================="); 
		 System.out.println(); 
	    InventoryServices();
	}

}
