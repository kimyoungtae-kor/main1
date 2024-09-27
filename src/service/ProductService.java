package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vo.*;

public class ProductService {
	private List<Product> productList = new ArrayList<>();
	private List<Product> baglist = new ArrayList<>();
	public ProductService() {
//		productList.add(new SingleMenu("삼겹살 (130g)", 9000,1,11));
//		productList.add(new SingleMenu("목살 (130g)", 9000,1,12));
//		productList.add(new SingleMenu("한우모듬 (150g)", 13000,1,13));
//		productList.add(new SingleMenu("꽃등심(150g)", 15000,1,14));
//		productList.add(new SingleMenu("항정살 (100g)", 9000,1,15));
//		productList.add(new SingleMenu("갈비살 (100g)", 9000,1,16));
//		productList.add(new SingleMenu("채끝등심 (130g)", 12000,1,16));
//		productList.add(new SingleMenu("토시살 (150g)", 18000,1,17));
//		productList.add(new SingleMenu("안창살 (130g)", 18000,1,18));
//		productList.add(new SingleMenu("공기밥", 1000,1,19));
//		productList.add(new SetMenu("A.세트\n"
//				+ "    	 -생고기 (200g)\n"
//				+ "    	 -양념 목살 (250g)\n "
//				+ "    	 -고추장 삼결살 (250g)\n", 40000,1,21));
//		productList.add(new SetMenu("B.세트\n"
//				+ "    	 -채끝등심 (150g)\n "
//				+ "    	 -차돌박이 (150g)\n "
//				+ "    	 -삼겹살(150g)\n "
//				+ "    	 -목살(150g)\n", 60000,1,22));
//		productList.add(new SetMenu("C.세트\n"
//				+ "    	 -삼겹살\n"
//				+ "    	 -목살\n"
//				+ "    	 -항정살(100g)"
//				+ "    	 -가브리살(100g)", 35000,1,23));
//		productList.add(new Drink("콜라", 1500,1,31));
//		productList.add(new Drink("사이다", 1500,1,32));
//		productList.add(new Drink("소주", 4000,1,33));
//		productList.add(new Drink("맥주", 4000,1,34));
//		productList.add(new Drink("청하", 5000,1,35));
//		productList.add(new Drink("매화수", 5000,1,36));
//		productList.add(new Drink("이슬톡톡", 5000,1,37));
//		

//		save();
		try {
			loadMenuPan();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getAlllist() {
		List<Product> getList = productList;
		System.out.println(getList);
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
	public void loadMenuPan() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream dis = new ObjectInputStream(new FileInputStream("C:\\Users\\tj\\eclipse-workspace\\mini\\src\\MenuPan.txt"));
		productList = (List<Product>) dis.readObject();
	}
	
	
	
	
	
	
	private void save() {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\tj\\eclipse-workspace\\mini\\src\\MenuPan.txt"));
			stream.writeObject(productList);
		}catch(Exception e){
			e.printStackTrace();
		}
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
