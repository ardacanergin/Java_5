import java.util.*;

public class RegularEmployee extends Employee {

	private double performanceScore;
	private double bonus;

	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double performanceScore) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department);
		this.performanceScore = performanceScore;
	}

	//Employee no-arg constructor needed for this implementation of this constructor
	public RegularEmployee(Employee employee, double performanceScore) {
		
		super(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getGender(),employee.getBirthDate(),employee.getMaritalStatus(),
				employee.getHasDriverLicense(),employee.getSalary(),employee.getHireDate(),employee.getDepartment());

		this.performanceScore=performanceScore;
	
	}

	public double getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(double performanceScore) {
		if(performanceScore<0) {
			throw new IllegalArgumentException("regularEmployee.setPerformanceScore argument: has to be positive.");
		}
		this.performanceScore = performanceScore;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		if(bonus<0) {
			throw new IllegalArgumentException("regularEmployee.setBonus argument:has to be positive.");
		}
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		
		String s = "RegularEmployee Info [performanceScore=" + performanceScore + ", bonus=" + bonus + "]"; 
		
		return s;
	}
}
