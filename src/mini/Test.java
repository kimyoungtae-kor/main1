package mini;

import service.*;
import common.*;

public class Test {
    public static void main(String[] args) throws Exception{
        ProductService productService = ProductService.getinstance();
        PayService payService = PayService.getInstance();
        OrderService orderService = OrderService.getInstance();

        System.out.println(" :: main :: " + orderService);

        productService.getAllList();
        int in = 0;
        while(true) {
            in = Utils.next("1. 카테고리별 조회 2. 장바구니 보기 3. 장바구니 담기 4. 삭제  5. 주문하기  6. 결제 내역 보기 7. 종료"
                    , Integer.class, i -> i < 8 && i > 0, "잘못된 입력");
            switch (in) {
                case 1:
                    productService.getList();
                    break;
                case 2:
                    orderService.printBag();
                    break;
                case 3:
                    productService.getAllList();
                    orderService.pickMenu();
                    break;
                case 4:
                    orderService.removeProduct();
                    break;
                case 5:
                    orderService.setOrder();
                    break;
                case 6:
                    payService.printOrderList();
                    break;
                case 7:
                    System.out.println("종료합니다");
                    return;
            }
        }
    }
}
