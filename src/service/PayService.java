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
    private final List<Order> orders = new ArrayList<>();
    private final ProductService productService = ProductService.getinstance();
    private final NumberFormat format = NumberFormat.getNumberInstance();
    private static final PayService payService = new PayService();
    private final OrderService orderService = OrderService.getInstance();

    {
        System.out.println(" :: payService :: " +orderService);
    }

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
     * @param bag - 장바구니 리스트
     */
    public void pay(int total, List<Product> bag) {
        int pay = Utils.next("1. 분할 결제  2. 일괄 결제  3. 결제 취소"
                , Integer.class, i -> i > 0 && i < 4, "입력 오류입니다 다시 시도해 주세요");
        if(pay == 1) {
            int cnt = Utils.next("인원 수를 입력해 주세요"
                    , Integer.class, i -> i > 1, "2명 이상의 인원 수를 입력해 주세요");
            System.out.println("1인당 결제할 금액은 " + format.format(total / cnt) + "원입니다");
            paySuccess(bag);
        } else if(pay == 2) {
            paySuccess(bag);
        } else {
            System.out.println("! 결제 취소 ! 메뉴판으로 돌아갑니다");
            productService.getAllList();
        }
    }

    /**
     * 결제 완료 및 내역 저장
     * @param bag - 장바구니 리스트
     */
    public void paySuccess(List<Product> bag) {
        List<Product> buyList = new ArrayList<>(bag);

        setOrderLists(buyList);
        Order order = orders.get(orders.size()-1);

        System.out.println("총 " + format.format(order.getTotalPrice())
                + "원 결제가 완료되었습니다 :: 주문 번호 [" + order.getOrderNum() + "]");
        orderService.cleanBag(bag);
    }

    /**
     *  주문 내역 추가 및 관리 리스트
     * @param bag - 장바구니에 담겨서 결제로 넘어온 리스트
     */
    public void setOrderLists(List<Product> bag) {
        List<Product> buyList = new ArrayList<>(bag);

        String str = String.valueOf(buyList.size());
        int total = 0;
        for(Product p : buyList) {
            str += p.getProductId();
            total += p.getPrice() * p.getAmount();
        }
        orders.add(new Order(buyList, str, total));
        for(Order order : orders) {
            for(Product p : order.getSaveOrder()) {
                System.out.println(p.getAmount() + " " + p.getProductId());
            }
        }
    }

    /**
     * 저장된 결제 내역 출력
     */
    public void printOrderList() {
        int total = 0;

        System.out.println("========== 결제 내역 ==========");
        for(Order order : orders) {
            System.out.println(order);
            for(Product p : order.getSaveOrder()) {
                System.out.println(" 주문 상품 :: " + p.getProductName() + " " + p.getAmount() + "개 ]");
            }
            System.out.println();
            total += order.getTotalPrice();
        }
        System.out.println("============================");
        System.out.println("총 매출 : " + format.format(total) + "원");
        System.out.println("============================");
    }
}
