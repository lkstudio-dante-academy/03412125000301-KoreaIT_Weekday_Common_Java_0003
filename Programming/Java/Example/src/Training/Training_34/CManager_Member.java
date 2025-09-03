package Training.Training_34;

import Training.Training_27.CMember;

import java.util.HashMap;
import java.util.Map;

/**
 * 회원 관리자
 */
public class CManager_Member {
	private Map<String, CMember> m_oMapMembers = new HashMap<>();
	
	/** 회원을 추가한다 */
	public void addMember(String a_oName, String a_oPNumber) {
		CMember oMember = new CMember(a_oName, a_oPNumber);
		m_oMapMembers.put(a_oName, oMember);
	}
	
	/** 회원을 제거한다 */
	public void removeMember(String a_oName) {
		m_oMapMembers.remove(a_oName);
	}
	
	/** 회원을 검색한다 */
	public void searchMember(String a_oName) {
		CMember oMember = m_oMapMembers.get(a_oName);
		oMember.showInfo();
	}
	
	/** 모든 회원을 출력한다 */
	public void showMembers_All() {
		for(String oKey : m_oMapMembers.keySet()) {
			CMember oMember = m_oMapMembers.get(oKey);
			oMember.showInfo();
			
			System.out.println();
		}
	}
	
	/** 회원을 탐색한다 */
	public CMember findMember(String a_oName) {
		return m_oMapMembers.getOrDefault(a_oName, null);
	}
}
