package Example.Example_27;

/**
 * 배열 리스트
 */
public class CList_Array<T> {
	private int m_nNumValues = 0;
	private T[] m_oValues = (T[])(new Object[5]);
	
	/** 값을 반환한다 */
	public T getVal(int a_nIdx) {
		return m_oValues[a_nIdx];
	}
	
	/** 개수를 반환한다 */
	public int getNumValues() {
		return m_nNumValues;
	}
	
	/** 값을 추가한다 */
	public void addVal(T a_tVal) {
		// 배열이 가득 찼을 경우
		if(m_nNumValues >= m_oValues.length) {
			T[] oValues_New = (T[])(new Object[m_oValues.length * 2]);
			System.arraycopy(m_oValues, 0, oValues_New, 0, m_nNumValues);
			
			m_oValues = oValues_New;
		}
		
		m_oValues[m_nNumValues++] = a_tVal;
	}
}
