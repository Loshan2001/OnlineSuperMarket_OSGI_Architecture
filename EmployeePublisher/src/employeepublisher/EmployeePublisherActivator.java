package employeepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EmployeePublisherActivator implements BundleActivator {

	 
	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("EmployeePublisher Start");
		EmployeePublisher employeePublisher = new EmployeePublisherImpl();
		publishServiceRegistration = bundleContext.registerService(EmployeePublisher.class.getName(), employeePublisher, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("EmployeePublisher Stop");
		publishServiceRegistration.unregister();
	}

}
