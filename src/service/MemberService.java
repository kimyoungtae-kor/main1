package service;
import java.util.ArrayList;
import java.util.List;
import vo.*;

public class MemberService {

	
	private List<Member> members= new ArrayList<>();
	
	
	int input = next("1.관리자 모드 , 2. 일반 모드");
	
	private int next (String member) {
	Member.add(new Member("uesr1", "pass1",1));
	Member.add(new Member("user2", "pass2",2));
	return input;
	}


	void checkName(String id, String pwd) {
		String str1 = id.toString();
		String s1 = new String(str1);
		
		String str2 = pwd.toString();
		String s2 = new String(str2);
	
	if (str2.length()< 1 || str1.length()> 10) {
		System.out.println("아이디를 1~10글자 사이로 입력하세요.");
		
	if (str2.length()< 1 || str2.length()> 10) {
		System.out.println("비밀번호를 1~10글자 사이로 입력하세요.");
				}	
			} 	
	}
	public void remove() {
		Member m = findByno(next("아이디 입력"));
		if(m == null) {
			System.out.println("입력한 아이디는 존재하지 않습니다.");
			return;
		}
	}


	private Member findByno(int next) {
		return null;
	}
				
		
			}
		
	
