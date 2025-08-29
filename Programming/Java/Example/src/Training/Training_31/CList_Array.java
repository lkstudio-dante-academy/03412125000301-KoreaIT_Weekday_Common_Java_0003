package Training.Training_31;

/**
 * 배열 리스트
 */
public class CList_Array {
    private int m_nNumValues = 0;
    private int[] m_oValues = new int[5];

    /** 값을 추가한다 */
    public void addVal(int a_nVal) {
        // 배열이 가득 찼을 경우
        if(m_nNumValues >= m_oValues.length) {
            int[] oValues_New = new int[m_oValues.length * 2];
            System.arraycopy(m_oValues, 0, oValues_New, 0, m_nNumValues);

            m_oValues = oValues_New;
        }

        m_oValues[m_nNumValues++] = a_nVal;
    }

    /** 배열을 순회한다 */
    public void enumerate(ICallback a_oCallback) {
        for(int i = 0; i < m_nNumValues; ++i) {
            a_oCallback.invoke(m_oValues[i]);
        }
    }
}
