package mini;

import common.Utils;
import service.MemberService;
import service.OrderService;
import service.PayService;
import service.ProductService;
import vo.Product;

public class Main {
	public static void main(String[] args) {
        ProductService productService = ProductService.getinstance();
        PayService payService = PayService.getInstance();
        OrderService orderService = OrderService.getInstance();
        MemberService mS = new MemberService();
        int in = 0;

        while(true) {
            in = Utils.next("1. 소비자 로그인 2.관리자 로그인 3. 종료", Integer.class, i -> i < 3 && i > 0, "1~2번 선택해주세요");
            int input = 0;
            int adminInput=0;
            switch (in) {
                case 1:
                   while(true) {
                	   input = Utils.next("1. 전체메뉴 출력 2. 카테고리별 조회 3. 장바구니 보기 4. 장바구니 담기 5. 장바구니 삭제  6. 주문하기  7. 결제 내역 보기 8. 종료"
                               , Integer.class, i -> i < 9 && i > 0, "1~8번까지만 입력해주세요");
                	   switch (input) {
                	   case 1:
                           productService.getAllList();
                           break;
                       case 2:
                           productService.getList();
                           break;
                       case 3:
                           orderService.printBag();
                           break;
                       case 4:
                           productService.getAllList();
                           orderService.pickMenu();
                           break;
                       case 5:
                           orderService.removeProduct();
                           break;
                       case 6:
                           orderService.setOrder();
                           break;
                       case 7:
                           payService.printOrderList();
                           break;
                       case 8:
                           System.out.println("종료합니다");
                           return;
                	   }
                   }
                case 2:
                	mS.login();
                	while(true) {
                		adminInput = Utils.next("1. 상품추가 2.상품삭제 3.관리자 비밀번호 변경 4.매출비교 5. 종료", Integer.class, i -> i < 6 && i > 0, "1~4번까지만 입력해주세요");
                		switch(adminInput) {
                			case 1:
                				productService.menuadd();
                				break;
                			case 2:
                				productService.menuRemove();
                				break;
                			case 3:
                				mS.setPwd();
                				break;
                			case 4:
                				System.out.println("미구현입니다");
                				break;
                			case 5:
                				System.out.println("종료합니다");
                                return;
                		}
                	}
                case 3:
                	 System.out.println("종료합니다");
                     return;
            }
        }
	}
	
	
	
}
