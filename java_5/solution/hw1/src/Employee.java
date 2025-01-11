import java.util.*;

public class Employee extends Person {

	private double salary;
	private Calendar hireDate;
	private Department department;
	public static int numberOfEmployees;


	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicense, double salary, Calendar hireDate, Department department) {

		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;

	}

	// overloaded constructor from Person person basically creates a new person as a
	// super instance of employee as same parameters as the person given in the
	// argument, the implementation of overloaded constructor of other classes
	// designed in the same way
	public Employee(Person person, double salary, Calendar hireDate, Department department) {

		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.getHasDriverLicense());
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;

		numberOfEmployees++;
	}

	// getter and setter methods for all data fields
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("employee.setSalary argument: negative!");
		}
		this.salary = salary;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public static int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public static void setNumberOfEmployees(int numberOfEmployees) {
		if (numberOfEmployees < 0) {
			throw new IllegalArgumentException("Employee.setNumberOfEmplooyes argument: negative!");
		}
		Employee.numberOfEmployees = numberOfEmployees;
	}

	// raise salary overloaded methods

	// raiseSalary throws IllegalArgumantException for invalid percentage
	public double raiseSalary(double percent) {
		if (0 <= percent && percent <= 1) {
			salary = salary + salary * percent;
		} else
			throw new IllegalArgumentException("Empoyee.raiseSalary argumant:percentage must be between 0-1.");
		return salary;
	}

	public double raiseSalary(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("employee.raiseSalary argument(int):negative!");
		}
		salary = salary + amount;
		return salary;
	}

	@Override
	public String toString() {

		String s = "Employee Info [salary= " + salary + ", hireDate= " + Test.printCalendar(hireDate) + "]";
		return s;
	}

}
