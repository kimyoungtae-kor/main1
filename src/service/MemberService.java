package service;
import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vo.*;
import common.*;


public class MemberService {
	
	
	private static final String UM = null;
	private List<Member> members = new ArrayList<>(); // 어플리케이션에 저장된 모든 회원들에 대한 정보.
   {
	   members.add(new Member("ID1", "PW1",1));
   }
   private Member findbyid(String ID) {
	   Member m = null;
	   for(Member aaa : members) {
		  if(aaa.getId().equals(ID)) {
			 m = aaa;
		  }
	   } 
	   return m;

} 
   public void login() {
//	  while (true) {
		  String UM = Utils.next("아이디를 입력하세요.", String.class, s ->findbyid(s) != null, "ID를 찾을 수 없습니다.");

		  String PW = Utils.next("비밀번호를 입력하세요.", String.class, s -> s.equals(findbyid(UM).getPwd()), "PWD를 찾을 수 없습니다.");
		                                                                        //== 문자열에 넣으면 주소비교가 된다.
		  System.out.println("관리자 로그인 되셨습니다.");
		 
//		  for(Member aaa : members) {
//			   if (aaa.getId().equals(UM)) {
//				   System.out.println("아이디를 확인했습니다.");
//				   if(aaa.getPwd().equals(PW)) {
//					   System.out.println("비밀번호를 확인했습니다.");
//				   }
//				   else {
//					   System.out.println("비밀번호가 틀렸습니다.");
//					   }
//				   	}
//			   		else {
//						   System.out.println("아이디가 틀렸습니다.");
//						   continue;
//					   } 
//			   			
//				   break;
//		  } 
	  }
	   

   
   	// 관리자 비밀번호 변경
   public void setPwd(String login , String longPw) {
	   String PW = Utils.next("비밀번호를 입력하세요.", String.class, s -> s.equals(findbyid(UM).getPwd()), "PWD를 찾을 수 없습니다.");
	   List<Member> members = new ArrayList<>();
	   
	   
	     }

}

	   
	
//	   
//	   
//	   
//	   
//	   
//   }

	   
   
//   private static final List<Member> aaa = null;
//   public void pw() {
//
//	   
//	   for(Member aaa  : members ) {
//		   if (aaa.getId().equals()) {
//			   System.out.println("로그인 되었습니다.");  
//		   } else {
//			   System.out.println("비밀번호가 틀렸습니다.");
//		   } 
//
//	   
//	   		}
//
//   
//   private int next (String member) {
// // 관리자 아이디.
//   return 0;
//            }
  

// 
//   void checkName(String id, String pwd) {
//      String str1 = id.toString();
//      String s1 = new String(str1);
//      
//      String str2 = pwd.toString();
//      String s2 = new String(str2);
//   
//   Scanner scanner = new Scanner(System.in);
//   int menu = Integer.parseInt(scanner.nextLine());
//   if (str1.length()< 1 || str1.length()> 10) {
//      System.out.println("아이디를 1~10글자 사이로 입력하세요.");
//      
//   if (str2.length()< 1 || str2.length()> 10) {
//      System.out.println("비밀번호를 1~10글자 사이로 입력하세요.");
//               }   
//         }
//   }
//   public void AdminLogin(Scanner scanner) {
//      System.out.println("관리자 "+ "아이디를 입력하세요.");
//      String id = scanner.nextLine();
//      System.out.println("관리자 비밀번호를 입력해주세요.");
//      String pwd = scanner.nextLine();


   
//   while(true) {
//      System.out.println("1. 관리자 로그인, 2. 소비자 로그인, 3. 종료.");
//      int input = Integer.parseInt(scanner.nextLine());
//      switch (input) {
//         case 1 :
//            System.out.println("관리자 아이디를 입력해주세요.");
//            if (adminId.equals(id) && adminPwd.equals(pwd)) {
//               System.out.println("관리자 비밀번호를 입력해주세요.");
//            } else {
//               System.out.println("관리자 아이디를 확인하세요.");
//            }
//            break;
//         case 2:
//         case 3:
//            return;
//      
//         default :
//            System.out.println("잘못된 선택입니다. 프로그램을 종료합니다.");
//            return;      
//                  }
//               }
//   
//            }
//   }



   

//   public void remove() {
//      Member m = findByno(next("아이디 입력"));
//      if(m == null) {
//         System.out.println("입력한 아이디는 존재하지 않습니다.");
//         return;
//      }
//   }
   
//   public void MeanMember() {
//      int input = next("1. 회원번호입니다. 주문을 해주세요. 2. 다시 처음으로 돌아가기.");
//      List<Member> tmp = null;
//      switch (input) {
//      case 1:
//         System.out.println("메뉴판 호출");
//         tmp = null;
//         break;
//      case 2:
//         System.out.println("다른 시스템을 입력해주세요.");
//         tmp = null;
//         break;
//      case 3:
//         System.out.println("프로그램을 종료합니다.");
//         break;
//      }
//   }


//   private Member findByno(int next) {
//      return null;
//   }
            
      
      
   
