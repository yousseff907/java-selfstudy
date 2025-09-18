
import java.util.*;

/*
Design an employee hierarchy:
- Employee (base class with name, ID, salary)
- Manager (has team of employees, can calculate team salary)
- Developer (has programming language skills)
- Designer (has design tools expertise)

Include methods to add/remove team members, calculate total compensation.
*/

abstract class Employee
{
    protected String name;
    protected String employeeId;
    protected double salary;

    public abstract double calculateTotalCompensation();

	public Employee(String name, String employeeId, double salary)
	{
		this.name = name;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	public String getName()
	{
		return (name);
	}

	public String getEmployeeId()
	{
		return (employeeId);
	}

	public double getSalary()
	{
		return (salary);
	}
}

class Manager extends Employee
{
    private List<Employee> team;

    public Manager(String name, String employeeId, double salary)
	{
		super(name, employeeId, salary);
		team = new ArrayList<>();
	}

	public void addToTeam(Employee employee)
	{
		team.add(employee);
	}

	public void removeFromTeam(Employee employee)
	{
		team.remove(employee);
	}

	public double employeeSalary(String employeeId)
	{
		double	totalSalary = 0.0;

		for(Employee employee : team)
		{
			if (employee.getEmployeeId().equals(employeeId))
			{
				totalSalary += employee.calculateTotalCompensation();
				return (totalSalary);
			}
		}
		
		return (-1);
	}

	public double teamSalary()
	{
		double	totalSalary = 0.0;

		for(Employee employee : team)
		{
			totalSalary += employee.calculateTotalCompensation();
		}
		
		return (totalSalary);
	}

	@Override
	public double calculateTotalCompensation()
	{
		return (salary + (team.size() * 2000.99999));
	}
}

class Developer extends Employee
{
    private List<String> programmingLanguages;

    public Developer(String name, String employeeId, double salary)
	{
        super(name, employeeId, salary);
		programmingLanguages = new ArrayList<>();
	}

	public void addLang(String lang)
	{
		programmingLanguages.add(lang);
	}

	public void removeLang(String lang)
	{
		programmingLanguages.remove(lang);
	}

	@Override
	public double calculateTotalCompensation()
	{
		return (salary + (programmingLanguages.size() * 5000.1099));
	}

}

class Designer extends Employee
{
    private List<String> designTools;

    public Designer(String name, String employeeId, double salary)
	{
        super(name, employeeId, salary);
		designTools = new ArrayList<>();
	}

	public void addTool(String tool)
	{
		designTools.add(tool);
	}

	public void removeTool(String tool)
	{
		designTools.remove(tool);
	}

	@Override
	public double calculateTotalCompensation()
	{
		return (salary + (designTools.size() * 5000.00778));
	}

}

public class EmployeeManagement
{
	public static void main(String[] args)
	{
		Manager manager = new Manager("Alice", "M001", 80000.976);
		Developer dev = new Developer("Bob", "D001", 70000.009);
		Designer designer = new Designer("Carol", "DS001", 65000.62946);

		dev.addLang("Java");
		dev.addLang("Python");
		designer.addTool("Photoshop");

		System.out.println("Developer compensation: $" + dev.calculateTotalCompensation());
		System.out.println("Designer compensation: $" + designer.calculateTotalCompensation());
		System.out.println("Manager (no team): $" + manager.calculateTotalCompensation());

		manager.addToTeam(dev);
		manager.addToTeam(designer);
		System.out.println("Manager (with team): $" + manager.calculateTotalCompensation());
		System.out.println("Total team salary: $" + manager.teamSalary());

		System.out.println("Bob's salary: $" + manager.employeeSalary("D001"));
		System.out.println("Missing employee: $" + manager.employeeSalary("XXX"));
	}	
}
