package Training.Training_30;

/**
 * 연결 리스트
 */
public class CList_Linked {
    /**
     * 노드
     */
    private static class CNode {
        public int m_nVal = 0;
        public CNode m_oNode_Next = null;
    }

    private CNode m_oNode_Head = new CNode();

    /** 값을 반환한다 */
    public int getVal(int a_nIdx) {
        CNode oNode = m_oNode_Head;

        for(int i = 0; i < a_nIdx; ++i) {
            oNode = oNode.m_oNode_Next;
        }

        return oNode.m_oNode_Next.m_nVal;
    }

    /** 개수를 반환한다 */
    public int getNumValues() {
        int nNumValues = 0;
        CNode oNode = m_oNode_Head;

        while(oNode.m_oNode_Next != null) {
            nNumValues += 1;
            oNode = oNode.m_oNode_Next;
        }

        return nNumValues;
    }

    /** 값을 추가한다 */
    public void addVal(int a_nVal) {
        CNode oNode_Tail = m_oNode_Head;

        while(oNode_Tail.m_oNode_Next != null) {
            oNode_Tail = oNode_Tail.m_oNode_Next;
        }

        oNode_Tail.m_oNode_Next = this.createNode(a_nVal);
    }

    /** 노드를 생성한다 */
    private CNode createNode(int a_nVal) {
        CNode oNode = new CNode();
        oNode.m_nVal = a_nVal;

        return oNode;
    }
}
