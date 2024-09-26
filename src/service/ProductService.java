package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vo.*;

public class ProductService {
	private List<Product> productList = new ArrayList<>();
	private List<Product> baglist = new ArrayList<>();
	public ProductService() {
		productList.add(new SingleMenu("삼겹살", 9000,1,11));
		productList.add(new SingleMenu("목살", 9000,1,12));
		productList.add(new SingleMenu("양념목살", 9000,1,13));
		productList.add(new SingleMenu("고추장 삼겹살", 9000,1,14));
		productList.add(new SingleMenu("항정살", 9000,1,15));
		productList.add(new SingleMenu("가브리살", 9000,1,16));
		productList.add(new SetMenu("A.세트\n"
				+ "    	 -삼겹살\n"
				+ "   	 -공기밥 ", 9000,1,21));
		productList.add(new SetMenu("B.세트\n"
				+ "    	 -삼겹살\n"
				+ "    	 -콜라 ", 9000,1,22));
		productList.add(new SetMenu("C.세트\n"
				+ "    	 -삼겹살\n"
				+ "    	 -목살", 18000,1,23));
		productList.add(new Drink("콜라", 9000,1,31));
		productList.add(new Drink("사이다", 9000,1,32));
		productList.add(new Drink("소주", 9000,1,33));
		productList.add(new Drink("맥주", 9000,1,34));
	}
	
	public void getAlllist() {
		List<Product> getList = productList;
		for(int i = 0 ;i <productList.size();i++) {
			System.out.println(getList);
		}
	}
	
	public List<Product> getlist(int catagory) {
		List<Product> getList = new ArrayList<>();
		for(Product list : productList) {
			if(list.getCategory() == catagory) {
				getList.add(list);
			}
		}
		return getList;
	}
//	
//	public List<Product> getlist(int category) {
//		Product product = null;
//		for(int i = 0 ; i<productList.size();i++) {
//			if(productList.get(i).getCategory() == category) {
//				product = productList.get(i);
//			}
//		}
//		return product;
//	}
	
//	public Product findcategory(int category) {
//		Product product = null;
//		for(int i =0 ; i<productList.size();i++) {
//			if(productList.get(i).getCategory() == category) {
//				product = productList.get(i);
//			}
//		}
//		getlist(product);
//		return null;
//	}
//	
//	public void getlist(Product product) {
//		List<Product> getList = (List<Product>) product;
//		for(int i = 0 ;i <productList.size();i++) {
//			System.out.println("("+getList.get(i).getProductId() + ")" +getList.get(i));
//		}
//	}
	

	
	
}
