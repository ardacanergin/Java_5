import java.util.*;

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicense;
	
	//i added no-arg constructor for a method in the test class which added by me as well
	public Person() {
		
	}

	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicense) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;

		// Constructor changing between data fields, throw IllegalArgumantException if
		// fails
		if (gender.trim().equalsIgnoreCase("Woman"))
			this.gender = 1;
		else if (gender.trim().equalsIgnoreCase("Man"))
			this.gender = 2;
		else
			throw new IllegalArgumentException("Person(constructor).gender must be either Woman(1) or Man(2).");

		if (maritalStatus.trim().equalsIgnoreCase("Single"))
			this.maritalStatus = 1;
		else if (maritalStatus.trim().equalsIgnoreCase("Married"))
			this.maritalStatus = 2;
		else
			throw new IllegalArgumentException(
					"Person(constructor).maritalStatus must be either Single(1) or Married(2).");

		if (hasDriverLicense.trim().equalsIgnoreCase("Yes"))
			this.hasDriverLicense = true;
		else if (hasDriverLicense.trim().equalsIgnoreCase("No"))
			this.hasDriverLicense = false;
		else
			throw new IllegalArgumentException(
					"Person(constructor).hasDriverLicense must be either Yes(True) or No(False).");

		this.birthDate = birthDate;

	}

	// Setter and Getter methods throws exception if wrong argument exception is
	// made
	public void setGender(String gender) {
		if (gender.length() < 3) {
			throw new IllegalArgumentException("person.setGender argument: at least 3 symbols needed.");
		}
		else if (gender.trim().equalsIgnoreCase("Woman"))
			this.gender = 1;
		else if (gender.trim().equalsIgnoreCase("Man"))
			this.gender = 2;
		else
			throw new IllegalArgumentException("Person.setGender argument:gender must be either Woman(1) or Man(2).");
	}

	public String getGender() {

		if (gender == 1)
			return "Woman";
		else if (gender == 2)
			return "Man";
		else
			return "invalidGetGender";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("person.setId argument:has to be positive integer");
		}
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() < 3) {
			throw new IllegalArgumentException("person.setFirstName argument:at least 3 symbols required.");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.trim().length() < 3) {
			throw new IllegalArgumentException("person.setLastName argument:at least 3 symbols required.");
		}
		this.lastName = lastName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {

		if (maritalStatus == 1)
			return "Single";
		else if (maritalStatus == 2)
			return "Married";
		else
			return "invalidGetMaritalStatus";
	}

	public void setMaritalStatus(String maritalStatus) {
		if (maritalStatus.length() < 3) {
			throw new IllegalArgumentException("person.setMaritalStatus argument: at least 3 symbols required.");
		}
		if (maritalStatus.trim().equalsIgnoreCase("Single"))
			this.maritalStatus = 1;
		else if (maritalStatus.trim().equalsIgnoreCase("Married"))
			this.maritalStatus = 2;
		else
			throw new IllegalArgumentException(
					"Person.setMaritalStatus argument:maritalStatus must be either Single(1) or Married(2).");
	}

	public String getHasDriverLicense() {
		if (hasDriverLicense)
			return "Yes";
		else if (!hasDriverLicense)
			return "No";
		else
			return "invalidGetHasDriverLicense";
	}

	public void setHasDriverLicense(String hasDriverLicense) { // we can't set at least 3 symbols rule in this method
																// since String "no" only has 2 symbols
		if (hasDriverLicense.trim().equalsIgnoreCase("Yes"))
			this.hasDriverLicense = true;
		else if (hasDriverLicense.trim().equalsIgnoreCase("No"))
			this.hasDriverLicense = false;
		else
			throw new IllegalArgumentException(
					"Person.sethasDriverLicense argumant:hasDriverLicense must be either Yes(True) or No(False).");
	}

	@Override // toString method override
	public String toString() {

		String s = "Person Info [id=" + id + ", firstName= " + firstName + ", lastName= " + lastName + ", gender= "
				+ getGender() + "]";
		return s;
	}

}
