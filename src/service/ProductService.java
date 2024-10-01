package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import vo.*;
import static common.Utils.*;
public class ProductService {
	private List<Product> productList = new ArrayList<>();
	{

		loadMenuPan();
	}
	
	public void getAllList() {
		List<Product> getList = productList;
		for(Product list:getList) {
			System.out.println(list);	
		}
		
	}
	

	public List<Product> orderMenupan(){
		return productList;
	}
	
	public void getList() {
		int input = next("1. 단품메뉴 2. 세트메뉴 3. 주류/음료",Integer.class,x -> x<4 && x>0,"1~3 까지만 입력해주세요");
		for(Product list : productList) {
			if(list.getCategory() == input) {
				System.out.println(list);
			}
		}
	}
	public void init() {
		productList.add(new SingleMenu("삼겹살 (130g)", 9000,11));
		productList.add(new SingleMenu("목살 (130g)", 9000,12));
		productList.add(new SingleMenu("한우모듬 (150g)", 13000,13));
		productList.add(new SingleMenu("꽃등심(150g)", 15000,14));
		productList.add(new SingleMenu("항정살 (100g)", 9000,15));
		productList.add(new SingleMenu("갈비살 (100g)", 9000,16));
		productList.add(new SingleMenu("채끝등심 (130g)", 12000,16));
		productList.add(new SingleMenu("토시살 (150g)", 18000,17));
		productList.add(new SingleMenu("안창살 (130g)", 18000,18));
		productList.add(new SingleMenu("공기밥", 1000,19));
		productList.add(new SetMenu("A.세트\n"
				+ "    	 -생고기 (200g)\n"
				+ "    	 -양념 목살 (250g)\n "
				+ "    	 -고추장 삼결살 (250g)\n", 40000,21));
		productList.add(new SetMenu("B.세트\n"
				+ "    	 -채끝등심 (150g)\n "
				+ "    	 -차돌박이 (150g)\n "
				+ "    	 -삼겹살(150g)\n "
				+ "    	 -목살(150g)\n", 60000,22));
		productList.add(new SetMenu("C.세트\n"
				+ "    	 -삼겹살\n"
				+ "    	 -목살\n"
				+ "    	 -항정살(100g)\n"
				+ "    	 -가브리살(100g)\n", 35000,23));
		productList.add(new Drink("콜라", 1500,31));
		productList.add(new Drink("사이다", 1500,32));
		productList.add(new Drink("소주", 4000,33));
		productList.add(new Drink("맥주", 4000,34));
		productList.add(new Drink("청하", 5000,35));
		productList.add(new Drink("매화수", 5000,36));
		productList.add(new Drink("이슬톡톡", 5000,37));
		
		save();
	}
	@SuppressWarnings("unchecked")
	public void loadMenuPan() {
		ObjectInputStream dis;
		try {
			dis = new ObjectInputStream(new FileInputStream("MenuPan.txt"));
			try {
				productList = (List<Product>) dis.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
