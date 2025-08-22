package Training.Training_29;

/**
 * 잔액 부족 예외
 */
public class CException_NotEnough extends Exception {
    /** 생성자 */
    public CException_NotEnough(int a_nNum) {
        super(String.format("계좌 번호 %d 에 잔액이 부족합니다.", a_nNum));
    }
}
