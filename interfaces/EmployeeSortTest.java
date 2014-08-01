package interfaces;

import java.util.*;

public class EmployeeSortTest 
{
	public static void main(String[] args)
	{
		Employee[] staff = new Employee[5];
		
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);
		staff[3] = new Employee("Billy", 15000);
		staff[4] = new Employee("Rara", 37000);
		
		//must implement the Comparable interface to use
		Arrays.sort(staff);
		
		//print out info about all Employee objects
		for (Employee e : staff)
		{
			System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
		}
		
	}
}
