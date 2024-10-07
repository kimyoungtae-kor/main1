package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import vo.*;
import common.*;


public class MemberService {
	
	
	private static final String UM = null;
	private List<Member> members = new ArrayList<>(); // 어플리케이션에 저장된 모든 회원들에 대한 정보.
	private String getId;
	private Object Password;
	private static MemberService ms = new MemberService();
   {

	   memberList();
   }
	public static MemberService getinstance() {
		return ms;
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
		  String UM = Utils.next("아이디를 입력하세요.", String.class, 
				  s ->findbyid(s) != null, "ID를 찾을 수 없습니다.");

		  String PW = Utils.next("비밀번호를 입력하세요.", String.class, 
				  s -> s.equals(findbyid(UM).getPwd()), "PWD를 찾을 수 없습니다.");
		                                                                        //== 문자열에 넣으면 주소비교가 된다.
		  System.out.println("관리자 로그인 성공.");
   }
    private void init() {
 	   members.add(new Member("ID1", "PW1",1,1));
    	userSave();
	}
	
   
   	// 관리자 비밀번호 변경
   public void setPwd() {
	   
	   
	   Member id = findbyid(Utils.next("아이디를 입력해주세요.", 
			   String.class, s-> findbyid(s) != null,
			   "입력한 아이디는 존재하지 않습니다."));
	   int no = id.getNO();
	   id.setPwd(Utils.next("변경할 비밀번호를 입력해주세요.",
			   String.class,x -> x.matches("^[1-9a-zA-Z!@#$%^&*()-]{0,99}"),
			   "영어와 숫자와 특수기호로만 0에서 9까지 입력 가능합니다."));
	   printMember();
	   userSave();
   }
   
   
   public void printMember() {
       List<Member> getList = members;
       for(Member list:getList) {
           System.out.println(list.toString());
           System.out.println("비밀번호 변경 되었습니다.");
       }
   }
	public void userSave() {
		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.txt"))){
			stream.writeObject(members);
	} catch (IOException m) {
		m.printStackTrace();
		
   		}
	}
	@SuppressWarnings("unchecked")
	public void memberList() {
		ObjectInputStream dis;
		try {
			dis = new ObjectInputStream(new FileInputStream("data.txt"));
			try {
				members = (List<Member>) dis.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}