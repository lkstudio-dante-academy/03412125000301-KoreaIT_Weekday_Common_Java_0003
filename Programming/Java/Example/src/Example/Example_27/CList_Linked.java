package Example.Example_27;

/**
 * 연결 리스트
 */
public class CList_Linked<T> {
	/**
	 * 노드
	 */
	private class CNode {
		public T m_tVal;
		public CNode m_oNode_Next = null;
	}
	
	int m_nNumValues = 0;
	private CNode m_oNode_Head = new CNode();
	
	/** 값을 반환한다 */
	public T getVal(int a_nIdx) {
		CNode oNode = this.getNode_At(a_nIdx);
		return oNode.m_oNode_Next.m_tVal;
	}
	
	/** 개수를 반환한다 */
	public int getNumValues() {
		return m_nNumValues;
	}
	
	/** 값을 추가한다 */
	public void addVal(T a_tVal) {
		CNode oNode = m_oNode_Head;
		
		while(oNode.m_oNode_Next != null) {
			oNode = oNode.m_oNode_Next;
		}
		
		oNode.m_oNode_Next = this.createNode(a_tVal);
		m_nNumValues += 1;
	}
	
	/** 값을 추가한다 */
	public void insertVal(int a_nIdx, T a_tVal) {
		CNode oNode = this.getNode_At(a_nIdx);
		CNode oNode_New = this.createNode(a_tVal);
		
		oNode_New.m_oNode_Next = oNode.m_oNode_Next;
		oNode.m_oNode_Next = oNode_New;
		
		m_nNumValues += 1;
	}
	
	/** 값을 제거한다 */
	public void removeVal(T a_tVal) {
		CNode oNode = this.findNode(a_tVal);
		
		// 값 제거가 불가능 할 경우
		if(oNode.m_oNode_Next == null) {
			return;
		}
		
		CNode oNode_Remove = oNode.m_oNode_Next;
		oNode.m_oNode_Next = oNode_Remove.m_oNode_Next;
		
		m_nNumValues -= 1;
	}
	
	/** 정보를 반환한다 */
	@Override
	public String toString() {
		StringBuilder oStrBuilder = new StringBuilder();
		
		for(int i = 0; i < m_nNumValues; ++i) {
			String oStr = String.format("%d, ", this.getVal(i));
			oStrBuilder.append(oStr);
		}
		
		return oStrBuilder.toString();
	}
	
	/** 노드를 반환한다 */
	private CNode getNode_At(int a_nIdx) {
		CNode oNode = m_oNode_Head;
		
		for(int i = 0; i < a_nIdx; ++i) {
			oNode = oNode.m_oNode_Next;
		}
		
		return oNode;
	}
	
	/** 노드를 탐색한다 */
	private CNode findNode(T a_tVal) {
		CNode oNode = m_oNode_Head;
		
		while(oNode.m_oNode_Next != null) {
			// 노드가 존재 할 경우
			if(a_tVal.equals(oNode.m_oNode_Next.m_tVal)) {
				break;
			}
			
			oNode = oNode.m_oNode_Next;
		}
		
		return oNode;
	}
	
	/** 노드를 생성한다 */
	private CNode createNode(T a_tVal) {
		CNode oNode = new CNode();
		oNode.m_tVal = a_tVal;
		
		return oNode;
	}
}
