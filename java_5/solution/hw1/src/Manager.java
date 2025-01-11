import java.util.*;

public class Manager extends Employee {

	private ArrayList<RegularEmployee> regularEmployees;
	private double bonusBudget;

	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) {

		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department);
		this.bonusBudget = bonusBudget;

		regularEmployees = new ArrayList<RegularEmployee>();

	}

	public Manager(Employee employee, double bonusBudget) {

		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(),
				employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicense(),
				employee.getSalary(), employee.getHireDate(), employee.getDepartment());

		this.bonusBudget = bonusBudget;
		
		regularEmployees = new ArrayList<RegularEmployee>();
	}

	public void addEmployee(RegularEmployee employee) {

		regularEmployees.add(employee);
	}

	public void removeEmployee(RegularEmployee employee) {
		regularEmployees.remove(employee);
	}

	// distributing bonus budget using given formula
	public void distributeBonusBudget() {

		for (int i =0; i < regularEmployees.size(); i++) {
			double unit = bonusBudget / ((((Employee) regularEmployees.toArray()[i]).getSalary()
					* ((RegularEmployee) regularEmployees.toArray()[i]).getPerformanceScore()));

			double bonus = unit * ((Employee) regularEmployees.toArray()[i]).getSalary()
					* ((RegularEmployee) regularEmployees.toArray()[i]).getPerformanceScore();

			((RegularEmployee) regularEmployees.toArray()[i]).setBonus(bonus);
		}
	}

	@Override
	public String toString() {
		String s = "Manager [id:" + getId() + ", " + getFirstName() + " " + getLastName() + " \n\t\t# of Employees:"
				+ regularEmployees.size() + "]";
		return s;
	}

	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	public double getBonusBudget() {
		return bonusBudget;
	}

	public void setBonusBudget(double bonusBudget) {
		if (bonusBudget < 0) {
			throw new IllegalArgumentException("manager.setBonusBudget argument:negative!");
		}

		this.bonusBudget = bonusBudget;
	}
}
