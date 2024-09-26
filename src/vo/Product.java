package vo;

public class Product {
	String productName;
	int price;
	int category;
	int productId;
	int amount;
	
	
	
	public Product(String productName, int price, int category,int amount,int productId) {
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.amount = amount;
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
		return " 상품명 : "+productName+" 가격 : "+price;
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
