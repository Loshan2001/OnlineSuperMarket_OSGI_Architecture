package employeeconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import employeepublisher.EmployeePublisher;

public class EmployeeConsumerActivator implements BundleActivator {

	 
	ServiceReference serviceReference;
	
	 

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("EmployeeConsumer started");
		serviceReference = bundleContext.getServiceReference(EmployeePublisher.class.getName());
		EmployeePublisher employeePublish = (EmployeePublisher) bundleContext.getService(serviceReference);
		System.out.println(employeePublish.publishService());
		employeePublish.EmployeeService();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("EmployeeConsumer stopped");
		bundleContext.ungetService(serviceReference);
	}

}
