import java.util.*;

public class Customer extends Person {

	private ArrayList<Product> products;

	public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicense, ArrayList<Product> products) {

		// Super constructor invoke
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);

		this.products = products;
	}

	public Customer(Person person, ArrayList<Product> products) {

		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.getHasDriverLicense());
		
		this.products = products;
	}

	// setter and getter methods
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	// methods to remove or add products to a customer's products list
	public void addProduct(Product produc) {

		products.add(produc);
	}

	public void removeProduct(Product product) {

		products.remove(product);
	}

	@Override
	public String toString() {

		String s = "Customer[id: " + super.getId() + " products=[" + toString(products) + "]]";
		return s;
	}

	// overloaded toString method for product list
	private String toString(ArrayList<Product> products) {

		String s = "";
		for (Product e : products) {
			s += "Product [productName=" + e.getProductName() + ", transactionDate=" + Test.printCalendar(e.getSaleDate())
					+ ", price=" + e.getPrice() + "]";
		}
		return s;

	}
}
