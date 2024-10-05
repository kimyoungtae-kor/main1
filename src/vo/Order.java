package vo;

import java.text.NumberFormat;
import java.util.List;

/**
 *  주문 내역 관리 vo
 */
public class Order {
    /**
     *  주문 상품 리스트
     */
    private final List<Product> saveOrder;

    /**
     *  주문한 상품의 수량 리스트
     */
    private final List<Integer> orderAmount;

    /**
     *  주문 번호
     */
    private final String orderNum;

    /**
     * 주문 금액
     */
    private final int totalPrice;
    private final NumberFormat format = NumberFormat.getNumberInstance();

    public Order(List<Product> saveOrder, List<Integer> orderAmount, String orderNum, int totalPrice) {
        this.saveOrder = saveOrder;
        this.orderAmount = orderAmount;
        this.orderNum = orderNum;
        this.totalPrice = totalPrice;
    }

    public List<Product> getSaveOrder() {
        return saveOrder;
    }

    public List<Integer> getOrderAmount() {
        return orderAmount;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "** 주문 번호 :: " + orderNum +
                ", 주문 금액 :: " + format.format(totalPrice) + "원";
    }
}
