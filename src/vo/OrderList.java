package vo;

import java.text.NumberFormat;
import java.util.List;

/**
 *  주문 내역 관리 vo
 */
public class OrderList {
    /**
     *  주문 상품 리스트
     */
    private List<Product> saveOrder;

    /**
     *  주문 번호
     */
    private String orderNum;

    /**
     * 주문 금액
     */
    private int totalPrice;
    private final NumberFormat format = NumberFormat.getNumberInstance();

    public OrderList(List<Product> saveOrder, String orderNum, int totalPrice) {
        this.saveOrder = saveOrder;
        this.orderNum = orderNum;
        this.totalPrice = totalPrice;
    }

    public List<Product> getSaveOrder() {
        return saveOrder;
    }

    public void setSaveOrder(List<Product> saveOrder) {
        this.saveOrder = saveOrder;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "[ 주문 번호 :: " + orderNum +
                ", 주문 상품 :: " + saveOrder +
                ", 주문 금액 :: " + format.format(totalPrice) + "원 ]";
    }
}
