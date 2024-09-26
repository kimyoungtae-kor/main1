package service;
import java.util.ArrayList;
import java.util.List;

import vo.*;

public class MemberService {
	
	private List<Member> member = new ArrayList<Member>();

	
	int input = next("1.관리자 모드 , 2. 일반 모드");
	
	private int next (String member) {
	Member.add(new Member("uesr1", "pass1",1));
	Member.add(new Member("user2", "pass2",2));
	System.out.println("입력 실패. 다시 입력하세요.");
	return input;
	}
}
