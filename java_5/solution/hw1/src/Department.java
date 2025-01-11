import java.util.*;

public class Department {

	private int departmentId;
	private String departmentName;

	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		if(departmentId<0) {
			throw new IllegalArgumentException("department.setDepartmentId argument: must be positive integer.");
		}
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		if(departmentName.length()<3) {
			throw new IllegalArgumentException("department.setDepartmentName argument: departmentName has to be more than 3 symbols");
		}
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {

		String s = "Deparment [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
		return s;
	}
}
