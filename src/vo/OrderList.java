package vo;

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

    public OrderList(List<Product> saveOrder, String orderNum, int totalPrice, int amount) {
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

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "주문 번호" + orderNum +
                ", 주문 상품" + saveOrder +
                ", 주문 금액" + totalPrice;
    }
}
