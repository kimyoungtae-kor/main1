package service;

import vo.*;
import common.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *  결제 서비스
 */
public class PayService {
    private List<Product> products = new ArrayList<>();
    private List<Product> bag = new ArrayList<>();
    private int total;

    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\정윤\\IdeaProjects\\main1\\src\\MenuPan.txt"))) {
            products = (ArrayList<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  주문 금액 확인 및 결제 진행 여부 판단
     */
    public void setOrder() {
        bag = findByAmount();
        for(Product p : bag) {
            System.out.printf("%5s  %d개\n", p.getProductName(), p.getAmount());
            total = total + p.getAmount() * p.getPrice();
        }
        System.out.println("총 주문 금액은 " + total + "원입니다");
        int goPay = Utils.next("결제를 진행하시겠습니까? (1. 예  / 2. 아니오)"
                    , Integer.class, i -> i > 0 && i < 3
                    , "예 또는 아니오만 입력해 주세요");
        if(goPay == 1) {
            pay();
        } else if(goPay == 2) {
            System.out.println("주문을 취소합니다 메뉴판으로 돌아갑니다");
        }
    }

    public void pay() {
        // 분할 결제 or 일괄 결제
    }

    /**
     * 상품을 장바구니에 담긴 항목만 검색
     * @return 장바구니에 담긴 상품 리스트를 리턴
     */
    private List<Product> findByAmount() {
        List<Product> pList = new ArrayList<>();
        for (Product product : products) {
            if (product.getAmount() > 0) {
                pList.add(product);
            }
        }
        return pList;
    }
}
