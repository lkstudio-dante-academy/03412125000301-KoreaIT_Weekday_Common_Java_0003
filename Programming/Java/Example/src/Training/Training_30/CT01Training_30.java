package Training.Training_30;

import java.util.Random;

/*
 * Java 연습 문제 30
 * - 연결 리스트 구현하기 (+ 중첩 클래스 활용)
 */

/**
 * Training 30
 */
public class CT01Training_30 {
    /** 초기화 */
    public static void start(String[] args) {
        Random oRandom = new Random();
        CList_Linked oListValues = new CList_Linked();

        for(int i = 0; i < 10; ++i) {
            int nVal = oRandom.nextInt(1, 100);
            oListValues.addVal(nVal);
        }

        System.out.println("=====> 리스트 <=====");

        for(int i = 0; i < oListValues.getNumValues(); ++i) {
            System.out.printf("%d, ", oListValues.getVal(i));
        }

        System.out.println();
    }
}
