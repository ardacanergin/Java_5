import java.util.*;

public class Project {

	private String projectName;
	private Calendar startDate;
	private boolean state;

	public Project(String projectName, Calendar startDate, String state) {
		this.projectName = projectName;
		this.startDate = startDate;

		if (state.equalsIgnoreCase("open"))
			this.state = true;
		else if (state.equalsIgnoreCase("close"))
			this.state = false;
		else if (!(state.equalsIgnoreCase("open")) || !(state.equalsIgnoreCase("close")))
			throw new IllegalArgumentException("Project.constructor argumant:state must be open or close");
	}

	// method updates the state data field
	public void setState(String state) {
		if (state.length() < 3) {
			throw new IllegalArgumentException("project.setState argument: has to be at least 3 symbols!");
		}
		if (state.equalsIgnoreCase("open"))
			this.state = true;
		else if (state.equalsIgnoreCase("close"))
			this.state = false;
		else if (!(state.equalsIgnoreCase("open")) || !(state.equalsIgnoreCase("close")))
			throw new IllegalArgumentException("project.setState argumant:state must be open or close");
	}

	public String getState() {

		if (state)
			return "Open";
		else if (!state)
			return "Close";
		else
			return "project.getState state null";
	}

	// method: closes the project if it is open
	public void close() {

		if (state)
			state = false; // state is false project closed

	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		if (projectName.length() < 3) {
			throw new IllegalArgumentException("project.setProjectName argument: needs at least 3 symbols.");
		}
		this.projectName = projectName;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		String s = "Project [projectName=" + projectName + ", startDate=" + Test.printCalendar(startDate) + ", state=" + state + "]";
		return s;
	}
}
