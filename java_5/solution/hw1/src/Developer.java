import java.util.*;

public class Developer extends RegularEmployee {

	private ArrayList<Project> projects;
	public static int numberOfDevelopers;

	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore,
			ArrayList<Project> projects) {

		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				performanceScore);

		projects = new ArrayList<Project>();
		numberOfDevelopers++;

	}

	public Developer(RegularEmployee regularEmployee, ArrayList<Project> projects) {

		super(regularEmployee.getId(), regularEmployee.getFirstName(), regularEmployee.getLastName(),
				regularEmployee.getGender(), regularEmployee.getBirthDate(), regularEmployee.getMaritalStatus(),
				regularEmployee.getHasDriverLicense(), regularEmployee.getSalary(), regularEmployee.getHireDate(),
				regularEmployee.getDepartment(), regularEmployee.getPerformanceScore());
		this.projects = projects;
		numberOfDevelopers++;

	}

	// methods to update projects of developers
	public void addProject(Project project) {
		projects.add(project);
	}

	public void removeProject(Project project) {
		projects.remove(project);
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}

	public static void setNumberOfDevelopers(int numberOfDevelopers) {
		Developer.numberOfDevelopers = numberOfDevelopers;
	}

	@Override
	public String toString() {

		return toString(projects);
	}

	private String toString(ArrayList<Project> projects) {
		String s = "";
		for (Project e : projects) {
			s += e.toString();
		}
		return s;
	}

}
