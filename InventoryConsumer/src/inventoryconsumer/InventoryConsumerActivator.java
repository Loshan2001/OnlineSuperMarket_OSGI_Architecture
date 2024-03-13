package inventoryconsumer;

import inventorypublisher.InventoryPublisher;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class InventoryConsumerActivator implements BundleActivator {
	ServiceReference serviceReference; 
 
	public void start(BundleContext bundleContext) throws Exception {
		 System.out.println("InventoryConsumer started");
//		 serviceReference = bundleContext.getServiceReference(InventoryPublisher.class.getName());
//		 InventoryPublisher inventoryPublish = (InventoryPublisher) bundleContext.getService(serviceReference);
//		 System.out.println(inventoryPublish.publishService());
//		 inventoryPublish.InventoryServices();
		 
		// Get the service reference for InventoryPublisher
	        serviceReference = bundleContext.getServiceReference(InventoryPublisher.class);
	        if (serviceReference != null) {
	            // Retrieve the InventoryPublisher service
	            InventoryPublisher inventoryPublisher = (InventoryPublisher) bundleContext.getService(serviceReference);
	            if (inventoryPublisher != null) {
	                // Use the service
	                System.out.println(inventoryPublisher.publishService());
	                inventoryPublisher.InventoryServices();
	            } else {
	                System.out.println("Failed to get InventoryPublisher service.");
	            }
	        } else {
	            System.out.println("InventoryPublisher service not available.");
	        }
	}

	public void stop(BundleContext bundleContext) throws Exception {
		 System.out.println("InventoryConsumer stopped");
		 bundleContext.ungetService(serviceReference);
	}
	
	

}
