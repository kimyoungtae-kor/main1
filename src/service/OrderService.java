package service;

import vo.*;
import common.*;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    // 주문이 실행되었을 때의 메서드에 지역변수를 사용해서 product의 amount에 추가되도록
    // 추가 주문 시 findBy로 메뉴를 찾아서 ++

    ProductService ps = new ProductService();
    List<Product> products = new ArrayList<Product>();
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
        List<Product> pList = findByAmount();
        System.out.println("===== 장바구니 =====");
        System.out.println("상품명\t  갯수  ");
        for(Product p : pList) {
            System.out.printf("%5s  %d개", p.getProductName(), p.getAmount());
        }
        System.out.println("===================");
        System.out.println("총 " + total + "원");
        System.out.println("===================");
    }

    private Product findById(int id) {
        Product p = null;

        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId() == i) {
                p = products.get(i);
            }
        }
        return p;
    }

    private List<Product> findByAmount() {
        List<Product> pList = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getAmount() != 0) {
                pList.add(product);
            }
        }
        return pList;
    }
}
