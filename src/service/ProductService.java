package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import vo.*;
import static common.Utils.*;
public class ProductService {
	private List<Product> productList = new ArrayList<>();
	private List<Product> categoryProduct;
	private NumberFormat formatter = NumberFormat.getNumberInstance();
	
	private static ProductService ps = new ProductService();
	
	
	{
		init();
		loadMenuPan();
	}
	
	public static ProductService getinstance() {
		return ps;
	}
	
	public void getAllList() {
		List<Product> getList = productList;
		getList.sort((a,b) -> a.getCategory() - b.getCategory());
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
		productList.add(new SingleMenu("삼겹살 (130g)", 9000,1,11));
		productList.add(new SingleMenu("목살 (130g)", 9000,1,12));
		productList.add(new SingleMenu("한우모듬 (150g)", 13000,1,13));
		productList.add(new SingleMenu("꽃등심(150g)", 15000,1,14));
		productList.add(new SingleMenu("항정살 (100g)", 9000,1,15));
		productList.add(new SingleMenu("갈비살 (100g)", 9000,1,16));
		productList.add(new SingleMenu("채끝등심 (130g)", 12000,1,16));
		productList.add(new SingleMenu("토시살 (150g)", 18000,1,17));
		productList.add(new SingleMenu("안창살 (130g)", 18000,1,18));
		productList.add(new SingleMenu("공기밥", 1000,1,19));
		productList.add(new SetMenu("A.세트\n"
				+ "    	 -생고기 (200g)\n"
				+ "    	 -양념 목살 (250g)\n "
				+ "    	 -고추장 삼결살 (250g)\n", 40000,2,21));
		productList.add(new SetMenu("B.세트\n"
				+ "    	 -채끝등심 (150g)\n "
				+ "    	 -차돌박이 (150g)\n "
				+ "    	 -삼겹살(150g)\n "
				+ "    	 -목살(150g)\n", 60000,2,22));
		productList.add(new SetMenu("C.세트\n"
				+ "    	 -삼겹살\n"
				+ "    	 -목살\n"
				+ "    	 -항정살(100g)\n"
				+ "    	 -가브리살(100g)\n", 35000,2,23));
		productList.add(new Drink("콜라", 1500,3,31));
		productList.add(new Drink("사이다", 1500,3,32));
		productList.add(new Drink("소주", 4000,3,33));
		productList.add(new Drink("맥주", 4000,3,34));
		productList.add(new Drink("청하", 5000,3,35));
		productList.add(new Drink("매화수", 5000,3,36));
		productList.add(new Drink("이슬톡톡", 5000,3,37));
		
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
	
	
	
	
	
	
	public void save(List<Product> tmp) {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("MenuPan.txt"));
			stream.writeObject(tmp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("MenuPan.txt"));
			stream.writeObject(productList);
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	
	public void menuadd() {
		int input = next("1.단품메뉴 추가 2.세트메뉴 추가 3. 드링크/주류 추가",Integer.class,x -> x>0 && x <4,"1~3번까지 입력해주세요");
		String aa = null;

		String input2 = next("메뉴명을 입력해주세요 >",String.class,x -> x.matches("^[가-힣a-zA-Z!@#$%-]{0,99}"),"영어와 한글로만 0~99자까지 입력가능합니다");
		
		int input3 = next("가격을 입력해주세요",Integer.class,x -> x > 0,"0이하의 범위는 허용하지않습니다");
		getAllList();
		System.out.println("===============================================================");
		Integer input4 = next("중복되지않는메뉴의 번호를 입력해주세요",Integer.class,x->findbyId(x) == null,"메뉴의 번호가 중복됩니다 다시 입력해주세요");

		if(input == 1) {
			productList.add(new SingleMenu(input2, input3, input, input4));
			aa = "단품메뉴 카테고리";
		}else if(input == 2) {
			productList.add(new SetMenu(input2, input3, input, input4));
			aa = "세트메뉴 카테고리";
		}else if(input == 3) {
			productList.add(new Drink(input2, input3, input, input4));
			aa = "음료/주류 카테고리";
		}
		System.out.println("===============================================================");
		System.out.println(input2 + " 이(가) " + formatter.format(input3) + " 가격에 " + input4 + " 번호로 " + aa + "에 등록되었습니다.");
		System.out.println("===============================================================");
		save();
	}
	public void menuRemove() {
		getAllList();
		Product input = findbyId(next("삭제하실 상품 번호를 입력해주세요",Integer.class,x -> findbyId(x) != null,"상품번호를 다시 확인해주세요"));
		productList.remove(input);
		
		save();
	}
	
	private Product findbyId(int id) {
		Product fp = null;
		for(Product findid : productList) {
			if(findid.getProductId() == id) {
				fp = findid;
			}
		}		
		return fp;
				
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
