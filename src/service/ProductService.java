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
	 {
//		productList.add(new SingleMenu("삼겹살 (130g)", 9000,11));
//		productList.add(new SingleMenu("목살 (130g)", 9000,12));
//		productList.add(new SingleMenu("한우모듬 (150g)", 13000,13));
//		productList.add(new SingleMenu("꽃등심(150g)", 15000,14));
//		productList.add(new SingleMenu("항정살 (100g)", 9000,15));
//		productList.add(new SingleMenu("갈비살 (100g)", 9000,16));
//		productList.add(new SingleMenu("채끝등심 (130g)", 12000,16));
//		productList.add(new SingleMenu("토시살 (150g)", 18000,17));
//		productList.add(new SingleMenu("안창살 (130g)", 18000,18));
//		productList.add(new SingleMenu("공기밥", 1000,19));
//		productList.add(new SetMenu("A.세트\n"
//				+ "    	 -생고기 (200g)\n"
//				+ "    	 -양념 목살 (250g)\n "
//				+ "    	 -고추장 삼결살 (250g)\n", 40000,21));
//		productList.add(new SetMenu("B.세트\n"
//				+ "    	 -채끝등심 (150g)\n "
//				+ "    	 -차돌박이 (150g)\n "
//				+ "    	 -삼겹살(150g)\n "
//				+ "    	 -목살(150g)\n", 60000,22));
//		productList.add(new SetMenu("C.세트\n"
//				+ "    	 -삼겹살\n"
//				+ "    	 -목살\n"
//				+ "    	 -항정살(100g)\n"
//				+ "    	 -가브리살(100g)\n", 35000,23));
//		productList.add(new Drink("콜라", 1500,31));
//		productList.add(new Drink("사이다", 1500,32));
//		productList.add(new Drink("소주", 4000,33));
//		productList.add(new Drink("맥주", 4000,34));
//		productList.add(new Drink("청하", 5000,35));
//		productList.add(new Drink("매화수", 5000,36));
//		productList.add(new Drink("이슬톡톡", 5000,37));
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
	
	public void getAllList() {
		List<Product> getList = productList;
		for(Product list : getList) {
			System.out.println(list);	
		}
		
	}
	
	public void  getList(int catagory) {
		List<Product> lists = new ArrayList<>();
		for(Product list : productList) {
			if(list.getCategory() == catagory) {
				lists.add(list);
			}
		}
		for(Product product : lists) {
			System.out.print(product+ "\n");
		}
	}
	
	
	
	public void loadMenuPan() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream dis = new ObjectInputStream(new FileInputStream("MenuPan.txt"));
		productList = (List<Product>) dis.readObject();
	}
	
	
	
	
	
	
	private void save() {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("MenuPan.txt"));
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
