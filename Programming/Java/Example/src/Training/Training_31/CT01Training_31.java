package Training.Training_31;

import java.util.Random;

/**
 * Training 31
 */
public class CT01Training_31 {
    /** 초기화 */
    public static void start(String[] args) {
        Random oRandom = new Random();
        CList_Array oListValues = new CList_Array();

        for(int i = 0; i < 10; ++i) {
            int nVal = oRandom.nextInt(1, 100);
            oListValues.addVal(nVal);
        }

        System.out.println("=====> 배열 - A <=====");

        oListValues.enumerate((a_nVal) -> {
            System.out.printf("%d, ", a_nVal);
        });

        /*
         * 아래와 같이 메서드 참조 (::) 를 활용하면 이미 정의 된 메서드를 특정 메서드의 입력으로 전달하는 것이
         * 가능하다. (+ 즉, 람다를 통해 메서드를 브릿지 해주는 경우 메서드 참조를 사용하면
         * 명령문을 좀 더 단순하게 작성하는 것이 가능하다.)
         */
        System.out.println("\n\n=====> 배열 - B <=====");
        oListValues.enumerate(CT01Training_31::printVal);

        System.out.println();
    }

    /** 값을 출력한다 */
    private static void printVal(int a_nVal) {
        System.out.printf("%d, ", a_nVal);
    }
}
