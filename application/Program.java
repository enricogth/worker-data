package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = input.nextLine();
		System.out.println("Enter worker data");
		System.out.print("Name: ");
		String workerName = input.nextLine();
		System.out.print("Level: ");
		String workerLevel = input.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = input.nextDouble();
		
		//instance a new object type Worker
		//the data of this object is: the name that i write, a instance of WorkerLevel with value that i write, and the base salary
		// and another object connected with Worker, the Department, and the name is what i write
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker: ");
		int n = input.nextInt();
		
		// do a for, because its a List
		// variable i starts with 1 because don't exist 0 contract
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			//do a SimpleDateFormat on beginning of the code to Date receive this format(dd/mm/...)
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(input.next());
			System.out.print("Value per hour: ");
			double valuePerHour = input.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = input.nextInt();
			
			//instance HourContract from entities with your values
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			//to conect this contract with the worker, you need to use worker.addContract from Worker(entities)
			//contract will be in a List, because there is a contract List in class Worker, and addContract will add in contract List
			worker.addContract(contract);
		}
			
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = input.next();
		//now you need to cut the String typed, get the month and tranform in Int number, same with year
		//month iniciate in character 0 until 2(2 is the /), year is 3 until the end
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		
		//now put the final result 
		System.out.println("Name" + worker.getName());
		//get the worker, associate the object Department, and then, associate another object, Name(department's name)
		System.out.println("Dapartment: " + worker.getDepartment().getName()); 
		//show how many the worker receive in this month and year
		//String.format to show olny 2 decimal values
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		
		input.close();

	}

}
