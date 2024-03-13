package employeepublisher;

public interface EmployeePublisher {
	public String publishService();
	public void AddEmployee(Employee empoyee);
	public void deleteEmployee(String employeeID);
	public void profile(String EmployeeID);
	public Employee updateStatus(String EmployeeID);
	public void ViewAllEmployee();
	public void EmployeeService();
}
