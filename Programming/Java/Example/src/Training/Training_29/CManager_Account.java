package Training.Training_29;

/**
 * 계좌 관리자
 */
public class CManager_Account {
	private int m_nNumAccounts = 0;
	private CAccount[] m_oAccounts = new CAccount[5];
	
	private static CManager_Account m_oInst = null;
	
	/** 생성자 */
	private CManager_Account() {
		// Do Something
	}
	
	/** 인스턴스를 반환한다 */
	public static CManager_Account getInst() {
		// 인스턴스가 없을 경우
		if(CManager_Account.m_oInst == null) {
			CManager_Account.m_oInst = new CManager_Account();
		}
		
		return CManager_Account.m_oInst;
	}
	
	/** 계좌를 추가한다 */
	public void addAccount(int a_nNum, int a_nAmount) {
		// 배열이 가득 찼을 경우
		if(m_nNumAccounts >= m_oAccounts.length) {
			CAccount[] oAccounts_New = new CAccount[m_oAccounts.length * 2];
			System.arraycopy(m_oAccounts, 0, oAccounts_New, 0, m_nNumAccounts);
			
			m_oAccounts = oAccounts_New;
		}
		
		CAccount oAccount = new CAccount(a_nNum, a_nAmount);
		m_oAccounts[m_nNumAccounts++] = oAccount;
	}
	
	/** 잔액을 증가 시킨다 */
	public void incrAmount(int a_nNum, int a_nIncr) {
		int nResult = this.findAccount(a_nNum);
		m_oAccounts[nResult].incrAmount(a_nIncr);
	}
	
	/** 모든 계좌를 출력한다 */
	public void showAccounts_All() {
		for(int i = 0; i < m_nNumAccounts; ++i) {
			m_oAccounts[i].showInfo();
			System.out.println();
		}
	}
	
	/** 계좌를 탐색한다 */
	public int findAccount(int a_nNum) {
		for(int i = 0; i < m_nNumAccounts; ++i) {
			// 계좌가 존재 할 경우
			if(a_nNum == m_oAccounts[i].getNum()) {
				return i;
			}
		}
		
		return -1;
	}
}
