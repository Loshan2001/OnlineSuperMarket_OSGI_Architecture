package employeepublisher;

public class Employee {
	private String EmployeeID;
	private String name;
	private String mail;
	private String gender;
	private String possition;
	private Double allowance;
	private Double otHour;
	private Double otRate;
	private Double netSalary;
	
	
	
	public Employee(String employeeID, String name, String mail, String gender, String possition, Double allowance,
			Double otHour, Double otRate, Double netSalary) {

		EmployeeID = employeeID;
		this.name = name;
		this.mail = mail;
		this.gender = gender;
		this.possition = possition;
		this.allowance = allowance;
		this.otHour = otHour;
		this.otRate = otRate;
		this.netSalary = netSalary;
	}



	public String getEmployeeID() {
		return EmployeeID;
	}



	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getPossision() {
		return possition;
	}



	public void setPossision(String possitions) {
		possition = possitions;
	}



	public Double getAllowance() {
		return allowance;
	}



	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}



	public Double getOtHour() {
		return otHour;
	}



	public void setOtHour(Double otHour) {
		this.otHour = otHour;
	}



	public Double getOtRate() {
		return otRate;
	}



	public void setOtRate(Double otRate) {
		this.otRate = otRate;
	}



	public Double getNetSalary() {
		return netSalary;
	}



	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}
	
	
	
}
