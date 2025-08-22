package Training.Training_29;

/**
 * 계좌 없음 예외
 */
public class CException_Missing extends Exception {
    /** 생성자 */
    public CException_Missing(int a_nNum) {
        super(String.format("계좌 번호 %d 은(는) 없는 계좌입니다.", a_nNum));
    }
}
