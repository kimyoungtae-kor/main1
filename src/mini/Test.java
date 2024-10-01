package mini;

import service.*;
import common.*;

public class Test {
    public static void main(String[] args) {
        ProductService ps = new ProductService();
        OrderService os = new OrderService();

        ps.getAllList();
        int in = 0;
        while(true) {
            in = Utils.next("1. 카테고리별 조회 2. 장바구니 보기 3. 장바구니 담기 4. 삭제  5. 주문하기 6. 종료"
                    , Integer.class, i -> i < 7 && i > 0, "잘못된 입력");
            switch (in) {
                case 1:
                    ps.getList();
                    break;
                case 2:
                    os.printBag();
                    break;
                case 3:
                    ps.getAllList();
                    os.pickMenu();
                    break;
                case 4:
                    os.removeProduct();
                    break;
                case 5:
                    os.setOrder();
                    break;
                case 6:
                    System.out.println("종료합니다");
                    return;
            }
        }
    }
}
