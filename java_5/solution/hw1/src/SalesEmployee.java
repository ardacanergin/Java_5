import java.util.*;

public class SalesEmployee extends RegularEmployee {

	private ArrayList<Product> sales;
	public static int numberOfSalesEmployees;

	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double performanceScore, ArrayList<Product> sales) {

		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				performanceScore);

		this.sales = sales;

		numberOfSalesEmployees++;
	}

	public SalesEmployee(RegularEmployee regularEmployee, ArrayList<Product> sales) {
		super(regularEmployee.getId(), regularEmployee.getFirstName(), regularEmployee.getLastName(),
				regularEmployee.getGender(), regularEmployee.getBirthDate(), regularEmployee.getMaritalStatus(),
				regularEmployee.getHasDriverLicense(), regularEmployee.getSalary(), regularEmployee.getHireDate(),
				regularEmployee.getDepartment(), regularEmployee.getPerformanceScore());

		this.sales = sales; 
		numberOfSalesEmployees++;
	}

	// methods to keep sale records for saleEmployees
	public void addSale(Product sale) {

		sales.add(sale);
	}

	public void removeSale(Product sale) {

		sales.remove(sale);
	}

	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}

	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees;
	}

	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
		if (numberOfSalesEmployees < 0) {
			throw new IllegalArgumentException("salesEmployee.setNumberOfSalesEmployees argument:negative!");
		}
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
	}

	@Override
	public String toString() {

		return toString(sales);
	}

	// i wanted to create a private toString method for classes that has lists that
	// will be converted to String because in this way i am able to left a room in
	// the actual toString method if i want to make any changes and i thought it may
	// be better for data encapsulation, similar implementations has been made in
	// other classes where instances has specific arrayLists
	private String toString(ArrayList<Product> sales) {
		String s = "";
		for (Product e : sales) {
			s += "Product[productName=" + e.getProductName() + ", transactionDate=" + Test.printCalendar(e.getSaleDate())
					+ ", price=" + e.getPrice() + "] ";
		}

		return s;

	}

}
