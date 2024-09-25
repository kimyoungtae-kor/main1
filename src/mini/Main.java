package mini;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Service aaa = new Service();
//		aaa.getAlllist();
		System.out.println("단품 메뉴 :");
		List<Product> single = aaa.getlist(1);
		for(Product single2 : single) {
			System.out.println(single2);
		}
		System.out.println("세트 메뉴 :");
		
		
		List<Product> setmenu = aaa.getlist(2);
		for(Product setmenu2 : setmenu) {
			System.out.println(setmenu2);
		}
		
		List<Product> sidemenu = aaa.getlist(3);
		
		for(Product sidemenu2 : sidemenu) {
			System.out.println(sidemenu2);
		}
	}
}
