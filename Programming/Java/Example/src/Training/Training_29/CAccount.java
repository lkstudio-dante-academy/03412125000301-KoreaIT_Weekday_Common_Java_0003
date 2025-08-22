package Training.Training_29;

/**
 * 계좌
 */
public class CAccount {
	private int m_nNum = 0;
	private int m_nAmount = 0;
	
	/** 생성자 */
	public CAccount(int a_nNum, int a_nAmount) {
		this.m_nNum = a_nNum;
        this.incrAmount(a_nAmount);
	}
	
	/** 계좌 번호를 반환한다 */
	public int getNum() {
		return m_nNum;
	}
	
	/** 잔액을 반환한다 */
	public int getAmount() {
		return m_nAmount;
	}
	
	/** 잔액을 증가 시킨다 */
	public void incrAmount(int a_nIncr) {
		m_nAmount = Math.max(0, m_nAmount + a_nIncr);
	}
	
	/** 정보를 출력한다 */
	public void showInfo() {
		System.out.printf("계좌 번호 : %d\n", m_nNum);
		System.out.printf("잔액 : %d\n", m_nAmount);
	}
}
