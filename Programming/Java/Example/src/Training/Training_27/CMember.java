package Training.Training_27;

/**
 * 회원
 */
public class CMember {
	private String m_oName = "";
	private String m_oPNumber = "";
	
	/** 생성자 */
	public CMember(String a_oName, String a_oPNumber) {
		this.m_oName = a_oName;
		this.m_oPNumber = a_oPNumber;
	}
	
	/** 이름을 반환한다 */
	public String getName() {
		return m_oName;
	}
	
	/** 정보를 출력한다 */
	public void showInfo() {
		System.out.printf("이름 : %s\n", m_oName);
		System.out.printf("전화 번호 : %s\n", m_oPNumber);
	}
}
