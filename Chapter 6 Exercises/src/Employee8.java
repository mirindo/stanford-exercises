
public class Employee8 {
	private String name;
	private String supervisor;
	private double annualSalary;
	
	public Employee8(String nameEmp, String supervisorName, double salary) {
		name = nameEmp;
		supervisor = supervisorName;
		annualSalary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSalary(double salary) {
		annualSalary = salary;
	}
	
	public double getSalary() {
		return annualSalary;
	}
	
	
	
}
