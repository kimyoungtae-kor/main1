package service;

import vo.*;
import common.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 주문 및 장바구니
 */
public class OrderService {
    private List<Product> products = new ArrayList<>();
    private List<Product> bag = new ArrayList<>();
    private int total;
    private final NumberFormat format = NumberFormat.getNumberInstance();
    private ProductService ps = ProductService.getinstance();

    {
        products = ps.orderMenupan();
    }

    /**
     *  메뉴 담기
     */
    public void pickMenu() {
        Product p;
        while (true) {
            int id = Utils.next("담을 메뉴를 골라 주세요 (주문을 완료하려면 0을 누르세요)"
                    , Integer.class, i -> findById(i) != null || i == 0, "잘못된 입력입니다.");
            if(id == 0) {
                System.out.println("주문을 완료합니다");
                break;
            }
            p = findById(id);

            int cnt = Utils.next("담을 갯수를 입력해 주세요 (뒤로 가기: 0)"
                    , Integer.class, i -> i >= 0, "유효한 갯수를 입력해 주세요");
            if(cnt == 0) {
                System.out.println("메뉴 선택으로 돌아갑니다");
                continue;
            }

            p.setAmount(p.getAmount() + cnt);
            System.out.println(p.getProductName() + " 상품을 " + cnt + "개 담았습니다");
            bag = findByAmount();
            ps.save(products);

            // 총 주문 금액
            for(Product pro : products) {
                if(id == pro.getProductId()) {
                    total = total + pro.getPrice() * cnt;
                }
            }
        }
    }

    /**
     *  장바구니 목록 조회
     */
    public void printBag() {
        bag = findByAmount();

        System.out.println("========== 장바구니 ==========");
        System.out.println("   No.\t  상품명\t  갯수  ");
        for(Product p : bag) {
            System.out.printf("%5d  %5s  %3d개\n", p.getProductId(), p.getProductName(), p.getAmount());
        }
        System.out.println("============================");
        System.out.println("총 " + format.format(total) + "원");
        System.out.println("============================");
    }

    /**
     *  장바구니 목록 삭제
     */
    public void removeProduct() {
        if(bag.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다");
            return;
        }

        Product product = findById(Utils.next("삭제할 메뉴의 번호를 입력하세요"
                , Integer.class, i -> findById(i) != null && findById(i).getAmount() != 0
                , "잘못된 상품 번호 혹은 목록에 없는 상품입니다 다시 시도해 주세요"));
        int cnt = Utils.next("삭제할 개수를 입력하세요"
                , Integer.class, i -> i <= product.getAmount() && i > 0
                , "삭제할 개수가 0개 혹은 담긴 개수보다 많습니다");
        int rm = Utils.next("해당 상품을 삭제하시겠습니까? (1. 예  / 2. 아니오)"
                , Integer.class, i -> i < 3 && i > 0
                , "오류가 발생했습니다 다시 시도해 주세요");
        if(rm == 1){
            System.out.println(product.getProductName() + " 상품 " + cnt + "개 삭제를 완료했습니다");
            product.setAmount(product.getAmount() - cnt);
            total = total - product.getPrice() * cnt;
        } else if(rm == 2){
            System.out.println("장바구니 목록으로 돌아갑니다");
            printBag();
        }

        ps.save(products);
        bag = findByAmount();
        printBag();
    }

    /**
     *  주문 금액 확인 및 결제 진행 여부 판단
     */
    public void setOrder() {
        for(Product p : bag) {
            System.out.printf("[%5s %d개] ", p.getProductName(), p.getAmount());
        }
        System.out.println();
        System.out.println("총 주문 금액은 " + format.format(total) + "원입니다");
        int goPay = Utils.next("결제를 진행하시겠습니까? (1. 예  / 2. 아니오)"
                , Integer.class, i -> i > 0 && i < 3
                , "예 또는 아니오만 입력해 주세요");
        if(goPay == 1) {
            pay();
        } else if(goPay == 2) {
            System.out.println("주문을 취소합니다 메뉴판으로 돌아갑니다");
            System.out.println(products);
        }
    }

    /**
     *  결제 방식 선택 및 결제로 넘어가기
     */
    public void pay() {
        int pay = Utils.next("1. 분할 결제  2. 일괄 결제  3. 결제 취소"
                , Integer.class, i -> i > 0 && i < 4, "입력 오류입니다 다시 시도해 주세요");
        if(pay == 1) {
            int cnt = Utils.next("인원 수를 입력해 주세요"
                    , Integer.class, i -> i > 1, "2명 이상의 인원 수를 입력해 주세요");
            System.out.println("1인당 결제할 금액은 " + format.format(total / cnt) + "원입니다");
        } else if(pay == 2) {

        } else {
            System.out.println("! 결제 취소 ! 메뉴판으로 돌아갑니다");
            System.out.println(products);
        }
    }

    /**
     * 상품을 아이디로 검색
     * @param id - 검색할 아이디
     * @return 아이디로 검색된 상품을 리턴
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
