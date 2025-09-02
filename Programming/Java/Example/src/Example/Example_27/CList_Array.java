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
	
	/** 값을 추가한다 */
	public void insertVal(int a_nIdx, T a_tVal) {
		// 마지막 위치에 값을 추가 할 경우
		if(a_nIdx == m_nNumValues) {
			this.addVal(a_tVal);
			return;
		}
		
		// 배열이 가득 찼을 경우
		if(m_nNumValues >= m_oValues.length) {
			T[] oValues_New = (T[])(new Object[m_oValues.length * 2]);
			System.arraycopy(m_oValues, 0, oValues_New, 0, m_nNumValues);
			
			m_oValues = oValues_New;
		}
		
		for(int i = m_nNumValues; i > a_nIdx; --i) {
			m_oValues[i] = m_oValues[i - 1];
		}
		
		m_oValues[a_nIdx] = a_tVal;
		m_nNumValues += 1;
	}
	
	/** 값을 제거한다 */
	public void removeVal(T a_tVal) {
		int nResult = this.FindVal(a_tVal);
		
		/** 값 제거가 불가능 할 경우 */
		if(nResult < 0) {
			return;
		}
		
		for(int i = nResult; i < m_nNumValues - 1; ++i) {
			m_oValues[i] = m_oValues[i + 1];
		}
		
		m_nNumValues -= 1;
	}
	
	/** 정보를 반환한다 */
	@Override
	public String toString() {
		StringBuilder oStrBuilder = new StringBuilder();
		
		for(int i = 0; i < m_nNumValues; ++i) {
			String oStr = String.format("%d, ", m_oValues[i]);
			oStrBuilder.append(oStr);
		}
		
		return oStrBuilder.toString();
	}
	
	/** 값을 탐색한다 */
	private int FindVal(T a_tVal) {
		for(int i = 0; i < m_nNumValues; ++i) {
			// 값이 존재 할 경우
			if(a_tVal.equals(m_oValues[i])) {
				return i;
			}
		}
		
		return -1;
	}
}
