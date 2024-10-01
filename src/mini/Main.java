package mini;
import java.util.List;
import java.util.Scanner;

import service.MemberService;
import service.ProductService;
import vo.Product;

public class Main {
    public static void main(String[] args) {
        ProductService aaa = new ProductService();
        Scanner scanner = new Scanner(System.in);
        MemberService MS = new MemberService();

        while(true) {
            System.out.println("1.관리자로그인 2.소비자로그인 3.종료");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("관리자 아이디를 입력해주세요");
                    String adminID = scanner.nextLine();
                    System.out.println("관리자 비밀번호를 입력해주세요.");
                    String adminPw = scanner.nextLine();
                    if (MS.adminId == adminID || MS.adminPwd == adminPw) {
                        System.out.println("로그인 되었습니다.");
                    }

                    return;

                }
                case 2: {

                }
                case 3: {
                    return;
                }
                default:
                    System.out.println("프로그램을 종료합니다");
                    return;
            }
        }
    }
}
