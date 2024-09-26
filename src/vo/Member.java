package vo;
import java.util.ArrayList;
import java.util.List;

public class Member {
	
	private String id;
	private String pwd;
	private int grade;

	
	private static List<Member> members = new ArrayList<>();
	
	// 관리자, 소비자 등록
	
	
	public Member(String id, String pwd, int grade) {
		
		this.id = id;
		this.pwd = pwd;
		this.grade = grade;
		
		
		}

	public static void add(Member member) {
		
		}
	}
