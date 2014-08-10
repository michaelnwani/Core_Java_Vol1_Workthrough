import java.util.*;

public class EmployeeTest 
{
	public static void main(String[] args)
	{
		//fill the staff array with three Employee objects
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Michael Nwani", 75000, 2014, 7, 1);
		staff[1] = new Employee("Carl Cracker", 70000, 2014, 6, 1);
		staff[2] = new Employee("Bob Pickler", 60000, 2014, 6, 5);
		
		//raise everyone's salary by 5%
		for (Employee e : staff)
		{
			e.raiseSalary(5);
		}
		
		//print out information about all Employee objects
		for (Employee e : staff)
		{
			System.out.println("name= " + e.getName() + ", salary= " + e.getSalary() + ", hireDay= " + e.getHireDay());
		}
		
		
	}
}

	class Employee
	{
		
		private String name;
		private double salary;
		private Date hireDay;
		
		public Employee(String n, double s, int year, int month, int day)
		{
			name = n;
			salary = s;
			GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
			//0 for January, the user would enter 1
			hireDay = calendar.getTime();
			
		}
		
		public String getName()
		{
			return name;
		}
		
		public double getSalary()
		{
			return salary;
		}
		
		public Object getHireDay()
		{
			return hireDay.clone();
		}
		
		public void raiseSalary(double byPercent)
		{
			double raise = salary * byPercent/100;
			salary += raise;
					
		}
	}

