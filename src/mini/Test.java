package mini;

import service.*;
import common.*;

public class Test {
    public static void main(String[] args) {
        ProductService aaa = new ProductService();
        OrderService bbb = new OrderService();

        aaa.getAllList();
        int in = 0;
        while(true) {
            in = Utils.next("1. 장바구니 보기 2. 장바구니 담기 3. 삭제  4. 주문하기 5. 종료"
                        , Integer.class, i -> i < 6 && i > 0, "잘못된 입력");
            switch (in) {
                case 1:
                    bbb.printBag();
                    break;
                case 2:
                    bbb.pickMenu();
                    break;
                case 3:
                    bbb.removeProduct();
                    break;
                case 4:
                    bbb.setOrder();
                    break;
                case 5:
                    System.out.println("종료합니다");
                    return;
            }
        }
    }
}
