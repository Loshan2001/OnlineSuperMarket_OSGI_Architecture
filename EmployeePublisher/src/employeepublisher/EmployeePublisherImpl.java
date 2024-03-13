package employeepublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeePublisherImpl implements EmployeePublisher {
	
	 private Map<String, Employee> employeeMap;

	    public EmployeePublisherImpl() {
	        employeeMap = new HashMap<>();
	        
	        Employee emp1 = new Employee("1111","lochan","lochansp@gmail.com","male","manager",25000.00,8.0,500.45,80000.00);
	        employeeMap.put(emp1.getEmployeeID(), emp1);
	        
	        Employee emp2 = new Employee("1112","kiru","kiru@gmail.com","male","manager",29000.00,8.0,540.45,85000.00);
	        employeeMap.put(emp2.getEmployeeID(), emp2);
	        
	        Employee emp3 = new Employee("1113","shangee","shangee@gmail.com","male","recruiter",22000.00,5.0,640.45,65000.00);
	        employeeMap.put(emp3.getEmployeeID(), emp3);
	        
	        Employee emp4 = new Employee("1114","lenin","lenin@gmail.com","male","HR",39000.00,8.0,530.45,95000.00);
	        employeeMap.put(emp4.getEmployeeID(), emp4);
	    }

	@Override
	public String publishService() {
		 
		return "execute the publish service of ServicePublisher";
	}

	@Override
	public void AddEmployee(Employee empoyee) {
		System.out.println();
		Scanner scn  = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		String eid =scn.next();
		System.out.println("Enter Employee Name : ");
		String ename =scn.next();
		System.out.println("Enter Employee Mail : ");
		String email =scn.next();
		System.out.println("Enter Employee Gender : ");
		String Gender =scn.next();
		System.out.println("Enter Employee possition : ");
		String possition =scn.next();
		System.out.println("Enter Employee Allowance : ");
		Double allowance =scn.nextDouble();
		System.out.println("Enter Employee OTHour : ");
		Double OTHour =scn.nextDouble();
		System.out.println("Enter Employee OTRate : ");
		Double OTRate =scn.nextDouble();
		System.out.println("Enter Employee NetSalary : ");
		Double NetSalary =scn.nextDouble();
		System.out.println();
		System.out.println();
		Employee emp = new Employee(eid,ename,email,Gender,possition,allowance,OTHour,OTRate,NetSalary);
		if (emp != null) {
            employeeMap.put(emp.getEmployeeID(), emp);
            System.out.println("Employee added successfully.");
        }
		else {
            System.out.println("Cannot add null employee.");
        }
		 EmployeeService();
		
	}

	@Override
	public void deleteEmployee(String employeeID) {
		System.out.println();
		Scanner scn  = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		String eid =scn.next();
		 
		if (employeeMap.containsKey(eid)) {
            employeeMap.remove(eid);
            System.out.println("Employee with ID " + eid + " deleted successfully.");
        } else {
            System.out.println("Employee with ID " + eid + " not found.");
        }
		 EmployeeService();
	}

	@Override
	public void profile(String EmployeeID) {
		System.out.println("=========================================================");
		System.out.println();
		 Scanner scn  = new Scanner(System.in);
			System.out.println("Enter Employee ID : ");
			String eid =scn.next();
			
		 if (employeeMap.containsKey(eid)) {
	            Employee employee = employeeMap.get(eid);
	            System.out.println("Employee Profile:");
	            System.out.println("-----------------------");
	            System.out.println("Employee ID:    " + employee.getEmployeeID());
	            System.out.println("Name:           " + employee.getName());
	            System.out.println("Email:          " + employee.getMail());
	            System.out.println("Gender:         " + employee.getGender());
	            System.out.println("Position:       " + employee.getPossision());
	            System.out.println("Allowance:      " + employee.getAllowance());
	            System.out.println("OT Hour:        " + employee.getOtHour());
	            System.out.println("OT Rate:        " + employee.getOtRate());
	            System.out.println("Net Salary:     " + employee.getNetSalary());
	            System.out.println("Total Salary:   " + (employee.getNetSalary() + employee.getAllowance() + (employee.getOtHour() * employee.getOtRate())));

	        } else {
	            System.out.println("Employee with ID " + eid + " not found.");
	        }
		 EmployeeService();
		
	}

	@Override
	public Employee updateStatus(String EmployeeID) {
		System.out.println();
		Scanner scn  = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		String eid =scn.next();
		
		 if (employeeMap.containsKey(eid)) {
		        Scanner scanner = new Scanner(System.in);
		        System.out.print("Enter new status for employee " + eid + ": ");
		        String newStatus = scanner.nextLine();
		        
		        Employee employee = employeeMap.get(eid);
		        employee.setPossision(newStatus);
		        employeeMap.put(eid, employee);
		        
		        System.out.println("Status updated successfully for employee " + eid);
		        EmployeeService();
		        return null;
		    } else {
		        System.out.println("Employee with ID " + eid + " not found.");
		        return null;
		    }
		 
	}

	@Override
	public void ViewAllEmployee() {
		 if (employeeMap.isEmpty()) {
		        System.out.println("No employees found.");
		    } else {
		        System.out.println("All Employees:");

		        // Print header row
		        System.out.printf("%-15s | %-20s | %-25s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s\n",
		                "Employee ID", "Name", "Mail", "Gender", "Position", "Allowance", "OT Hour", "OT Rate", "Net Salary");
		        
		        // Print employee details
		        for (Employee employee : employeeMap.values()) {
		            System.out.printf("%-15s | %-20s | %-25s | %-10s | %-10s | %-10.2f | %-10.2f | %-10.2f | %-10.2f\n",
		                    employee.getEmployeeID(), employee.getName(), employee.getMail(), employee.getGender(),
		                    employee.getPossision(), employee.getAllowance(), employee.getOtHour(), employee.getOtRate(),
		                    employee.getNetSalary());
		        }
		    }
		 EmployeeService();
	}

	@Override
	public void EmployeeService() {
		System.out.println();
		Scanner scn  = new Scanner(System.in);
		System.out.println("select following options : ");
		System.out.println("1.Add Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Delete Employee");
		System.out.println("4.View all Employee");
		System.out.println("5.View Profile");
		System.out.println("6.Exit");
		 
	    int option = scn.nextInt();
		System.out.println();
		System.out.println();
		while(option != 6) {
			if(option == 1) {
				AddEmployee(null);
			}
			else if(option == 2) {
				updateStatus(null);
			}
			else if(option == 3) {
				deleteEmployee(null);
			}
			else if(option == 4) {
				ViewAllEmployee();
			}
			else if(option == 5) {
				profile(null);
			}
			else {
				System.out.println("oops! Enter the correct option :");
			}
			 option = scn.nextInt();
		}
		 System.out.println("Thank you");
		
	}

}
