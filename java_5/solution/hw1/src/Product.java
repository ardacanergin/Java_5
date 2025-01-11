import java.util.*;

public class Product {
	private String productName;
	private Calendar saleDate;
	private double price;

	public Product(String productName, Calendar saleDate, double price) {

		this.productName=productName;
		this.saleDate=saleDate;
		this.price=price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		if(productName.length()<3) {
			throw new IllegalArgumentException("products.setProductName argument: productName has to be more than 3 symbols");
		}
		this.productName = productName;
	}

	public Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price<0) {
			throw new IllegalArgumentException("product.setPrice argument:has to be positive.");
		}
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return productName + " $" + price + "\n" + Test.printCalendar(saleDate);
	}
	
}
