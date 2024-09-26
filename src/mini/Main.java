package mini;

import java.util.List;
import java.util.Scanner;

import service.ProductService;
import vo.Product;

public class Main {
	public static void main(String[] args) {
		ProductService aaa = new ProductService();
		aaa.getAlllist();
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
		Scanner scanner = new Scanner(System.in);
		
//		while(true) {
//			System.out.println("1.소비자로그인 2.관리자로그인 3.종료");
//			int input = scanner.nextInt();
//			switch (input) {
//				case 1: {
//				
//				
//				}
//				case 2: {
//					
//				}
//				case 3: {
//					return;
//				}
//			default:
//				System.out.println("프로그램을 종료합니다");
//				return;
//			}
//		}
	}
}
