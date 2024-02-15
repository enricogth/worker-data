package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	// a Worker just can have 1 department
	private Department department;
	// a Worker can have more than 1 contract, thats why you use List
	// and import ArrayList to use List
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
	}

	// when a composition have many, you don't include List in constructors
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	
	// ----- remove setContract, bc another list are being assigned to contracts -----
	//public void setContracts(List<HourContract> contracts) {
	//	this.contracts = contracts;
	//}
	
	
	
	// use contract as argument, to add more contracts
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	// use contract as argument to remove any contract from contracts
	public void removeContract(HourContract contract) {	
		contracts.remove(contract);
	}
	
	//create variable sum
	// import Calendar
	//for each HoursContract(c) from contracts list do:
	// define a date to the contract with cal.setTime
	// get a YEAR from Calendar, and a MONTH
	// if the year = calendar year(c_year) and month too, the sum will receive = baseSalary + totalValue(valuePerHour * Hours)
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
	
	
}
