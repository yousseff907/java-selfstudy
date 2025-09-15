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
	public Employee(String name, String employee, double salary)
	{
	}
}

class Manager extends Employee
{
    private List<Employee> team;

}

class Developer extends Employee
{
    private List<String> programmingLanguages;

}

public class EmployeeManagement
{
	
}
