package Example.Example_22;

/**
 * 위젯
 */
public class CWidget {
	private int m_nVal = 0;
	private static int m_nVal_Static = 0;
	
	/** 정보를 출력한다 */
	public void showInfo() {
		System.out.printf("멤버 변수 : %d\n", m_nVal);
		System.out.printf("클래스 변수 : %d\n", CWidget.m_nVal_Static);
	}
}
