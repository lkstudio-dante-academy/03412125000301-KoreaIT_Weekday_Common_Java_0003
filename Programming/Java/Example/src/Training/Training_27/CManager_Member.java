package Training.Training_27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 회원 관리자
 */
public class CManager_Member {
	private int m_nNumMembers = 0;
	private CMember[] m_oMembers = new CMember[5];
	
	/** 회원을 추가한다 */
	public void addMember(String a_oName, String a_oPNumber) {
		// 배열이 가득 찼을 경우
		if(m_nNumMembers >= m_oMembers.length) {
			CMember[] oMembers_New = new CMember[m_oMembers.length * 2];
			
			for(int i = 0; i < m_nNumMembers; ++i) {
				oMembers_New[i] = m_oMembers[i];
			}
			
			m_oMembers = oMembers_New;
		}
		
		CMember oMember = new CMember(a_oName, a_oPNumber);
		m_oMembers[m_nNumMembers++] = oMember;
	}
	
	/** 회원을 제거한다 */
	public void removeMember(String a_oName) {
		int nResult = this.findMember(a_oName);
		
		for(int i = nResult; i < m_nNumMembers - 1; ++i) {
			m_oMembers[i] = m_oMembers[i + 1];
		}
		
		m_nNumMembers -= 1;
	}
	
	/** 회원을 검색한다 */
	public void searchMember(String a_oName) {
		int nResult = this.findMember(a_oName);
		m_oMembers[nResult].showInfo();
	}
	
	/** 모든 회원을 출력한다 */
	public void showMembers_All() {
		for(int i = 0; i < m_nNumMembers; ++i) {
			m_oMembers[i].showInfo();
			System.out.println();
		}
	}
	
	/** 회원을 탐색한다 */
	public int findMember(String a_oName) {
		for(int i = 0; i < m_nNumMembers; ++i) {
			// 회원이 존재 할 경우
			if(a_oName.equals(m_oMembers[i].getName())) {
				return i;
			}
		}
		
		return -1;
	}
	
	/** 회원을 로드한다 */
	public void loadMembers_FromFile(String a_oPath_File) {
		File oFile = new File(a_oPath_File);
		
		// 파일이 없을 경우
		if(!oFile.exists()) {
			return;
		}
		
		try(BufferedReader oReader = new BufferedReader(new FileReader(oFile))) {
			m_nNumMembers = 0;
			
			while(oReader.ready()) {
				String[] oInfo_Member = oReader.readLine().split(",");
				this.addMember(oInfo_Member[0], oInfo_Member[1]);
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/** 회원을 저장한다 */
	public void saveMembers_ToFile(String a_oPath_File) {
		File oFile = new File(a_oPath_File);
		
		try(BufferedWriter oWriter = new BufferedWriter(new FileWriter(oFile))) {
			for(int i = 0; i < m_nNumMembers; ++i) {
				CMember oMember = m_oMembers[i];
				
				oWriter.write(oMember.toString());
				oWriter.newLine();
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
