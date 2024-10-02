package service;

import vo.*;
import common.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *  결제 서비스
 */
public class PayService {
    private final List<OrderList> orderLists = new ArrayList<>();
    private final ProductService productService = ProductService.getinstance();
    private final NumberFormat format = NumberFormat.getNumberInstance();
    private static final PayService payService = new PayService();
    private final OrderService orderService = new OrderService();

    /**
     *  싱글톤
     * @return PayService
     */
    public static PayService getInstance() {
        return payService;
    }

    /**
     *  결제 진행
     * @param total - 최종 결제 금액
     */
    public void pay(int total, List<Product> plist) {
        int pay = Utils.next("1. 분할 결제  2. 일괄 결제  3. 결제 취소"
                , Integer.class, i -> i > 0 && i < 4, "입력 오류입니다 다시 시도해 주세요");
        if(pay == 1) {
            int cnt = Utils.next("인원 수를 입력해 주세요"
                    , Integer.class, i -> i > 1, "2명 이상의 인원 수를 입력해 주세요");
            System.out.println("1인당 결제할 금액은 " + format.format(total / cnt) + "원입니다");
            paySuccess(plist);
        } else if(pay == 2) {
            paySuccess(plist);
        } else {
            System.out.println("! 결제 취소 ! 메뉴판으로 돌아갑니다");
            productService.getAllList();
        }
    }

    /**
     * 결제 완료 및 내역 저장
     */
    public void paySuccess(List<Product> pList) {
        setOrderLists(pList);
        OrderList oList = orderLists.get(orderLists.size()-1);

        System.out.println("dd");
        System.out.println(orderLists);
        System.out.println("dd");

        System.out.println("총 " + format.format(oList.getTotalPrice())
                + "원 결제가 완료되었습니다 :: 주문 번호 [" + oList.getOrderNum() + "]");
        orderService.cleanBag(pList);

        System.out.println("dd");
        System.out.println(orderLists);
        System.out.println("dd");
    }

    /**
     *  주문 내역 추가 및 관리 리스트
     * @param o - 장바구니에 담겨서 결제로 넘어온 리스트
     */
    public void setOrderLists(List<Product> o) {
        String str = String.valueOf(o.size());
        int total = 0;
        for(Product p : o) {
            str += p.getProductId();
            total += p.getPrice() * p.getAmount();
        }
        orderLists.add(new OrderList(o, str, total));
    }

    /**
     * 저장된 결제 내역 출력
     * 보완 필요함
     */
    public void printOrderList() {
        System.out.println("========== 결제 내역 ==========");
        System.out.println(orderLists.size());
//        oList.forEach(System.out::println);

        for(OrderList o : orderLists) {
            System.out.println(" ::::: " + o.getOrderNum() + " :: " + o.getTotalPrice() + " :: ");
        }
//        System.out.println("============================");
//        System.out.println("총 매출" + format.format(total) + "원");
//        System.out.println("============================");
    }
}
