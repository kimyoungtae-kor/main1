package vo;
import java.util.ArrayList;
import java.util.List;

public class Member {
	
	private String id;
	private String pwd;
	private int grade;
	private int NO;

	
	private static List<Member> members = new ArrayList<>();
	
	// 관리자, 소비자 등록
	
	
	public Member(String id, String pwd, int grade, int NO) {
		
		this.id = id;
		this.pwd = pwd;
		this.grade = grade;
		this.NO = NO;
		
		
		
		}

	public static void add(Member member) {
		
		}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}
	
	public void InPut() {

	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", grade=" + grade + ", NO=" + NO + "]";
	}
	
}

