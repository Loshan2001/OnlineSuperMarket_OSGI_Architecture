package inventorypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class InventoryPublisherActivator implements BundleActivator {

	 

	 
	ServiceRegistration InventorypublishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		 System.out.println("InventoryPublisher start");
		 InventoryPublisher inventoryPublisher = new InventorypublisherImpl();
		 InventorypublishServiceRegistration = bundleContext.registerService(InventoryPublisher.class.getName(), inventoryPublisher, null);
		 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		 System.out.println("InventoryPublisher stop");
		 InventorypublishServiceRegistration.unregister();
	}

}
