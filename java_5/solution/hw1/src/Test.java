import java.io.*;
import java.util.*;

//Arda Can Ergin 150123060
public class Test {

	public static void main(String[] args) {

		File inputFile = new File("input.txt");
		File outputFile = new File("output.txt");

		ArrayList<Object> objectList = new ArrayList<Object>();

		try {
//			if (inputFile.createNewFile() || outputFile.createNewFile()) {
//				System.out.println("File created " + inputFile.isAbsolute() + inputFile.getAbsolutePath());
//			} else
//				System.out.println("file exsits");

			Scanner input = new Scanner(inputFile);
			while (input.hasNext()) {
				switch (input.next()) {

				case "Department":
					objectList.add(new Department(input.nextInt(), input.next()));
					break;

				case "Project":
					String projectName = input.next();
					// to convert string to a calendar object
					String[] stringDate = input.next().split("/");
					int[] date = new int[3];
					for (int i = 0; i < date.length; i++) {
						date[i] = Integer.parseInt(stringDate[i]);
					}
					Calendar calendar = Calendar.getInstance();
					calendar.set(date[2], date[1], date[0]);

					String status = input.next();

					objectList.add(new Project(projectName, calendar, status));

					break;

				case "Product":
					String productName = input.next();
					stringDate = input.next().split("/");
					date = new int[3];
					for (int i = 0; i < date.length; i++) {
						date[i] = Integer.parseInt(stringDate[i]);
					}
					calendar = Calendar.getInstance();
					calendar.set(date[2], date[1], date[0]);

					double price = input.nextDouble();

					objectList.add(new Product(productName, calendar, price));

					break;

				case "Person":

					String personName = input.next();
					String personLastName = input.next();
					int personId = input.nextInt();
					String gender = input.next();

					stringDate = input.next().split("/");
					date = new int[3];
					for (int i = 0; i < date.length; i++) {
						date[i] = Integer.parseInt(stringDate[i]);
					}
					calendar = Calendar.getInstance();
					calendar.set(date[2], date[1], date[0]);

					String marital = input.next();
					String licence = input.next();

					objectList
							.add(new Person(personId, personName, personLastName, gender, calendar, marital, licence));

					break;

				case "Employee":

					int id = input.nextInt();
					double salary = input.nextDouble();

					stringDate = input.next().split("/");
					date = new int[3];
					for (int i = 0; i < date.length; i++) {
						date[i] = Integer.parseInt(stringDate[i]);
					}
					calendar = Calendar.getInstance();
					calendar.set(date[2], date[1], date[0]);

					String department = input.next();

					objectList.add(new Employee(findPerson(id, objectList), salary, calendar,
							findDepartment(department, objectList)));

					break;

				case "Manager":

					id = input.nextInt();
					double bonus = input.nextDouble();

					objectList.add(new Manager(findEmployee(id, objectList), bonus));

					break;

				case "RegularEmployee":

					id = input.nextInt();
					double performance = input.nextDouble();

					objectList.add(new RegularEmployee(findEmployee(id, objectList), performance));

					break;

				case "Developer":

					id = input.nextInt();

					String[] projects = input.nextLine().split(" ");
					ArrayList<Project> project = new ArrayList<>();
					for (int i = 0; i < projects.length; i++) {
						project.add(findProject(projects[i], objectList));
					}
					project.remove(null);

					objectList.add(new Developer(findRegular(id, objectList), project));

					break;

				case "SalesEmployee":

					id = input.nextInt();

					String[] sales = input.nextLine().split(" ");
					ArrayList<Product> sale = new ArrayList<>();
					for (int i = 0; i < sales.length; i++) {
						sale.add(findProduct(sales[i], objectList));
					}
					sale.remove(null);

					objectList.add(new SalesEmployee(findRegular(id, objectList), sale));

					break;

				case "Customer":

					id = input.nextInt();

					String[] products = input.nextLine().split(" ");
					ArrayList<Product> product = new ArrayList<>();
					for (int i = 0; i < products.length; i++) {
						product.add(findProduct(products[i], objectList));
					}

					product.remove(null);

					objectList.add(new Customer(findPerson(id, objectList), product));

					break;

				}
			}
		} catch (Exception ex) {
			System.out.println("exception");
		}

		// add employees to managers
		/*
		 * manager123.addEmployee(developer111); manager123.addEmployee(regular156);
		 * manager123.addEmployee(sales167); manager256.addEmployee(sales213);
		 * manager256.addEmployee(developer247);
		 */

		((Manager) objectList.toArray()[28]).addEmployee(((Developer) objectList.toArray()[33]));
		((Manager) objectList.toArray()[28]).addEmployee(((RegularEmployee) objectList.toArray()[32]));
		((Manager) objectList.toArray()[28]).addEmployee(((SalesEmployee) objectList.toArray()[36]));
		((Manager) objectList.toArray()[43]).addEmployee(((SalesEmployee) objectList.toArray()[41]));
		((Manager) objectList.toArray()[43]).addEmployee(((Developer) objectList.toArray()[46]));

		((Manager) objectList.get(28)).distributeBonusBudget();
		((Manager) objectList.get(43)).distributeBonusBudget();

		// manager raiseSalary 0.2 ((Manager) objectList.get(1)).raiseSalary(0.2);
		// ((Manager) objectList.get(11)).raiseSalary(0.2);
		((Manager) objectList.get(28)).raiseSalary(0.2);
		((Manager) objectList.get(43)).raiseSalary(0.2);
		// regularEmployee raiseSalary 0.3 ((RegularEmployee)
		// objectList.get(3)).raiseSalary(0.3);
		((RegularEmployee) objectList.get(33)).raiseSalary(0.3);
		// developer raiseSalary 0.23 ((Developer)
		// objectList.get(0)).raiseSalary(0.23); ((Developer)
		// objectList.get(10)).raiseSalary(0.23);
		((Developer) objectList.get(33)).raiseSalary(0.23);
		((Developer) objectList.get(46)).raiseSalary(0.23);
		// SalesEmployee raiseSalary 0.18 ((SalesEmployee)
		// objectList.get(4)).raiseSalary(0.18); ((SalesEmployee)
		// objectList.get(7)).raiseSalary(0.18);
		((SalesEmployee) objectList.get(36)).raiseSalary(0.18);
		((SalesEmployee) objectList.get(41)).raiseSalary(0.18);
		// raise salesEmployee salary based on max sales
		if (totalSale((SalesEmployee) objectList.get(36)) > totalSale((SalesEmployee) objectList.get(41))) {
			((SalesEmployee) objectList.get(36)).raiseSalary(10000);
		} else if (totalSale((SalesEmployee) objectList.get(36)) < totalSale((SalesEmployee) objectList.get(41))) {
			((SalesEmployee) objectList.get(41)).raiseSalary(10000);
		} else {
			System.out.println("SaleEmployees has equal amount of sales(price): no raiseSalary.");
		}

		try {
			PrintWriter print = new PrintWriter(new FileWriter(outputFile, true));

			// print first department: Accounting
			for (int i = 0; i < 20; i++) {
				print.print("*");
			}
			print.println();
			print.print(findDepartment("Accounting", objectList).toString());
			print.println();
			print.print("\t" + ((Manager) objectList.get(28)).toString());
			print.println(); // developer111
			print.println("\t\t1.Developer");
			print.println("\t\t\t" + ((Person) objectList.get(14)).toString());
			print.println("\t\t\t" + ((Employee) objectList.get(29)).toString());
			print.println("\t\t\t" + ((RegularEmployee) objectList.get(30)).toString());
			print.println("\t\t\t" + ((Developer) objectList.get(33)).toString()); // sales167
			print.println("\t\t2.SalesEmployee");
			print.println("\t\t\t" + ((Person) objectList.get(18)).toString());
			print.println("\t\t\t" + ((Employee) objectList.get(34)).toString());
			print.println("\t\t\t" + ((RegularEmployee) objectList.get(35)).toString());
			print.println("\t\t\t" + ((SalesEmployee) objectList.get(36)).toString());
			// regular156
			print.println("\t\t3.RegularEmployee");
			print.println("\t\t\t" + ((Person) objectList.get(17)).toString());
			print.println("\t\t\t" + ((Employee) objectList.get(31)).toString());
			print.println("\t\t\t" + ((RegularEmployee) objectList.get(32)).toString());

			// printing second department
			for (int i = 0; i < 20; i++) {
				print.print("*");
			}
			print.println();
			print.print(findDepartment("Marketing", objectList).toString());
			print.println();
			print.print("\t" + ((Manager) objectList.get(43)).toString());
			print.println(); // developer247
			print.println("\t\t1.Developer");
			print.println("\t\t\t" + ((Person) objectList.get(24)).toString());
			print.println("\t\t\t" + ((Employee) objectList.get(44)).toString());
			print.println("\t\t\t" + ((RegularEmployee) objectList.get(45)).toString());
			print.println("\t\t\t" + ((Developer) objectList.get(46)).toString()); // sales213
			print.println("\t\t2.SalesEmployee");
			print.println("\t\t\t" + ((Person) objectList.get(21)).toString());
			print.println("\t\t\t" + ((Employee) objectList.get(39)).toString());
			print.println("\t\t\t" + ((RegularEmployee) objectList.get(40)).toString());
			print.println("\t\t\t" + ((SalesEmployee) objectList.get(41)).toString());

			// printing customers
			for (int i = 0; i < 19; i++) {
				if (i == 10)
					print.print("CUSTOMERS");
				else
					print.print("*");
			}
			print.println(); // customer224
			print.println(((Customer) objectList.get(37)).toString()); // customer267
			print.println(((Customer) objectList.get(38)).toString()); // customer178
			print.println(((Customer) objectList.get(47)).toString());

			print.close();

			// print people
			for (int i = 0; i < 19; i++) {
				if (i == 10)
					print.print("PEOPLE");
				else
					print.print("*");
				print.println();
				print.println(((Person) objectList.get(16)).toString()); 
				print.println(((Person) objectList.get(20)).toString()); 
				print.println(((Person) objectList.get(23)).toString());

			}
		} catch (Exception e) {

			System.out.println("exception");
		}

	}

	// implementing a simple method to get instance of calendar easier
	public static Calendar newCalendar(int day, int month, int year) {

		Calendar newCalendar = Calendar.getInstance();
		newCalendar.set(year, month, day);
		return newCalendar;
	}

	// method for finding person easily using their id
	// not used in the program because it is not convenient however it could come in
	// handy in situations such as bigger group of people
	public static Person find(int id, Person[] list) {

		Person person = new Person();

		for (int i = 0; i < list.length; i++) {
			if (list[i].getId() == id) {
				person = list[i];
			} // i don't know why but i couldn't make that method work even if i correctly
				// implement if and else into the for so i had to change it a little
		}
		return person;
	}

	// method to find the total sales of a salesEmployee
	public static double totalSale(SalesEmployee sales) {

		double amount = 0;
		for (int i = 0; i < sales.getSales().size(); i++) {
			amount += sales.getSales().get(i).getPrice();
		}

		return amount;

	}

	// method to make calendar look more readable
	public static String printCalendar(Calendar calendar) {

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		return "" + day + "/" + month + "/" + year;

	}

	// methods to find right object from id
	public static Person findPerson(int id, ArrayList<Object> objectList) {

		for (Object e : objectList) {
			if (e instanceof Person && ((Person) e).getId() == id) {
				return (Person) e;
			}

		}
		return null;
	}

	public static Employee findEmployee(int id, ArrayList<Object> objectList) {
		for (Object e : objectList) {
			if (e instanceof Employee && ((Employee) e).getId() == id) {
				return (Employee) e;
			}
		}
		return null;
	}

	public static RegularEmployee findRegular(int id, ArrayList<Object> objectList) {
		for (Object e : objectList) {
			if (e instanceof RegularEmployee && ((RegularEmployee) e).getId() == id) {
				return (RegularEmployee) e;
			}
		}
		return null;
	}

	public static Department findDepartment(String department, ArrayList<Object> objectList) {
		for (Object e : objectList) {
			if (e instanceof Department && ((Department) e).getDepartmentName().equalsIgnoreCase(department)) {
				return (Department) e;
			}
		}
		return null;
	}

	public static Project findProject(String name, ArrayList<Object> objectList) {

		for (Object e : objectList) {
			if (e instanceof Project && ((Project) e).getProjectName().equalsIgnoreCase(name)) {
				return (Project) e;
			}
		}
		return null;
	}

	public static Product findProduct(String name, ArrayList<Object> objectList) {

		for (Object e : objectList) {
			if (e instanceof Product && ((Product) e).getProductName().equalsIgnoreCase(name)) {
				return (Product) e;
			}
		}
		return null;
	}

}
