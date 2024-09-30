package vo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Product implements Serializable {
	private String productName;
	private int price;
	private int category;
	private int productId;
	private int amount;
	private NumberFormat format = NumberFormat.getNumberInstance();
	
	
	public Product(String productName, int price, int category,int productId) {
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "("+productId+")"+" 상품명 : "+productName+" 가격 : "+format.format(price) +"\n" ;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
