package Training.Training_36;

import Training.Training_27.CMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 회원 관리자
 */
public class CManager_Member {
	private Connection m_oConnection = null;
	
	/** 생성자 */
	public CManager_Member(String a_oPath_File) {
		try {
			m_oConnection = DriverManager.getConnection(a_oPath_File);
			this.executeQuery("CREATE TABLE IF NOT EXISTS MemberTable(Name TEXT PRIMARY KEY, PNumber TEXT)");
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/** 회원을 추가한다 */
	public void addMember(String a_oName, String a_oPNumber) {
		String oQuery = String.format("INSERT OR IGNORE INTO MemberTable(Name, PNumber) VALUES(\"%s\", \"%s\")",
				a_oName, a_oPNumber);
		
		this.executeQuery(oQuery);
	}
	
	/** 회원을 제거한다 */
	public void removeMember(String a_oName) {
		String oQuery = String.format("DELETE FROM MemberTable where Name = \"%s\"", a_oName);
		this.executeQuery(oQuery);
	}
	
	/** 회원을 검색한다 */
	public void searchMember(String a_oName) {
		CMember oMember = this.findMember(a_oName);
		oMember.showInfo();
	}
	
	/** 모든 회원을 출력한다 */
	public void showMembers_All() {
		try(Statement oStatement = m_oConnection.createStatement()) {
			String oQuery = "SELECT * FROM MemberTable";
			ResultSet oResult = oStatement.executeQuery(oQuery);
			
			while(oResult.next()) {
				System.out.printf("이름 : %s\n", oResult.getString(1));
				System.out.printf("전화 번호 : %s\n\n", oResult.getString(2));
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/** 회원을 탐색한다 */
	public CMember findMember(String a_oName) {
		try(Statement oStatement = m_oConnection.createStatement()) {
			String oQuery = String.format("SELECT * FROM MemberTable where Name = \"%s\"", a_oName);
			ResultSet oResult = oStatement.executeQuery(oQuery);
			
			return oResult.next() ?
					new CMember(oResult.getString(1), oResult.getString(2)) : null;
		} catch(Exception oException) {
			oException.printStackTrace();
		}
		
		return null;
	}
	
	/** SQL 쿼리문을 실행한다 */
	private void executeQuery(String a_oQuery) {
		try(Statement oStatement = m_oConnection.createStatement()) {
			oStatement.execute(a_oQuery);
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
