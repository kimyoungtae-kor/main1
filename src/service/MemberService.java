package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vo.*;

public class MemberService {
	public String adminId = "admin1";
	public String adminPwd = "adminP1";
//	private static final List<Member> aaa = null;


//	private List<Member> members = new ArrayList<>();
	
	
//	private int next (String member) {
//	Member.add(new Member("uesr1", "pass1",1));
//	return 0;
//	}


	void checkName(String id, String pwd) {
		String str1 = id.toString();
		String s1 = new String(str1);
		
		String str2 = pwd.toString();
		String s2 = new String(str2);
	
	Scanner scanner = new Scanner(System.in);
	String menu = scanner.nextLine();
	if (str1.length()< 1 || str1.length()> 10) {
		System.out.println("아이디를 1~10글자 사이로 입력하세요.");
		
	if (str2.length()< 1 || str2.length()> 10) {
		System.out.println("비밀번호를 1~10글자 사이로 입력하세요.");
				}	
			} 	
	}
//	public void remove() {
//		Member m = findByno(next("아이디 입력"));
//		if(m == null) {
//			System.out.println("입력한 아이디는 존재하지 않습니다.");
//			return;
//		}
//	}
	
//	public void MeanMember() {
//		int input = next("1. 회원번호입니다. 주문을 해주세요. 2. 다시 처음으로 돌아가기.");
//		List<Member> tmp = null;
//		switch (input) {
//		case 1:
//			System.out.println("메뉴판 호출");
//			tmp = null;
//			break;
//		case 2:
//			System.out.println("다른 시스템을 입력해주세요.");
//			tmp = null;
//			break;
//		case 3:
//			System.out.println("프로그램을 종료합니다.");
//			break;
//		}
	}


//	private Member findByno(int next) {
//		return null;
//	}
				
		
		
	
