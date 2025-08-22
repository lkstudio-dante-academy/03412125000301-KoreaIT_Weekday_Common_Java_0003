package Training.Training_29;

/**
 * 계좌 중복 예외
 */
public class CException_Duplicate extends Exception {
    /** 생성자 */
    public CException_Duplicate(int a_nNum) {
        super(String.format("계좌 번호 %d 은(는) 이미 존재하는 계좌입니다.", a_nNum));
    }
}
