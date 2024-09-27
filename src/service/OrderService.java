package service;

import vo.*;
import common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 주문 및 장바구니
 */
public class OrderService {
    List<Product> products = new ArrayList<>();
    List<Product> pList = new ArrayList<>();
    int total;

    {
        // 메모장 불러와서 products에 넣기
    }
    
    /**
     *  메뉴 담기
     */
    public void pickMenu() {
        while (true) {
            int id = Utils.next("담을 메뉴를 골라 주세요 (주문을 완료하려면 0을 누르세요)"
                    , Integer.class, i -> findById(i) != null || i == 0, "잘못된 입력입니다.");
            if(id == 0) {
                System.out.println("주문을 완료합니다");
                break;
            }

            int cnt = Utils.next("담을 갯수를 입력해 주세요 (뒤로 가기: 0)"
                    , Integer.class, i -> i >= 0, "유효한 갯수를 입력해 주세요");
            if(cnt == 0) {
                System.out.println("메뉴 선택으로 돌아갑니다");
                continue;
            }

            // 총 주문 금액
            for(Product p : products) {
                if(id == p.getProductId()) {
                    total = total + p.getPrice() * cnt;
                }
            }
        }
    }

    /**
     *  장바구니 목록 조회
     */
    public void printBag() {
        pList = findByAmount();

        System.out.println("===== 장바구니 =====");
        System.out.println("No.\t  상품명\t  갯수  ");
        for(Product p : pList) {
            System.out.printf("%5d  %5s  %d개", p.getProductId(), p.getProductName(), p.getAmount());
        }
        System.out.println("===================");
        System.out.println("총 " + total + "원");
        System.out.println("===================");
    }

    /**
     *  장바구니 목록 삭제
     */
    public void removeProduct() {
        Product product = findById(Utils.next("삭제할 메뉴의 번호를 입력하세요"
                                    , Integer.class, i -> findById(i) != null
                                    , "잘못된 상품 번호입니다 다시 시도해 주세요"));
        products.remove(product);
    }

    /**
     * 상품을 아이디로 검색
     * @param id
     * @return
     */
    private Product findById(int id) {
        Product p = null;

        for (Product product : products) {
            if (product.getProductId() == id) {
                p = product;
            }
        }
        return p;
    }

    /**
     * 상품을 장바구니에 담긴 항목만 검색
     * @return
     */
    private List<Product> findByAmount() {
        List<Product> pList = new ArrayList<>();
        for (Product product : products) {
            if (product.getAmount() != 0) {
                pList.add(product);
            }
        }
        return pList;
    }
}
